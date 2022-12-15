package com.example.lewords.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.ColorDrawable
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.lewords.R
import com.example.lewords.bottomnavigation.words.adapters.WordListAdapter

class WordsSwipeCallback(private var wordListAdapter: WordListAdapter,
                         private var context: Context) : ItemTouchHelper.Callback() {


    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val swipeDirectionFlags = ItemTouchHelper.LEFT or  ItemTouchHelper.RIGHT
        return  makeMovementFlags(0,swipeDirectionFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val itemPosition = viewHolder.adapterPosition
        if (direction == ItemTouchHelper.RIGHT){
            wordListAdapter.onItemSwipeRight(itemPosition)
            return
        }
        if (direction == ItemTouchHelper.LEFT){
            wordListAdapter.onItemSwipeLeft(itemPosition)
            return
        }
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

        val rightSwipeBackground = viewHolder.itemView.findViewById<Button>(R.id.rightButton)
        val leftSwipeBackground = viewHolder.itemView.findViewById<Button>(R.id.leftButton)

        if (dX > 0){
            rightSwipeBackground.backgroundTintList = ContextCompat.getColorStateList(context,R.color.black)
            rightSwipeBackground.setTextColor(ContextCompat.getColor(context,R.color.white))
        }
        else{
            rightSwipeBackground.backgroundTintList = ContextCompat.getColorStateList(context,R.color.white)
            rightSwipeBackground.setTextColor(ContextCompat.getColor(context,R.color.black))
        }
        if(dX < 0){

            leftSwipeBackground.backgroundTintList =  ContextCompat.getColorStateList(context,R.color.light_green)
            leftSwipeBackground.setTextColor(ContextCompat.getColor(context,R.color.white))
        }
        else{
            leftSwipeBackground.backgroundTintList =ContextCompat.getColorStateList(context,R.color.white)
            leftSwipeBackground.setTextColor(ContextCompat.getColor(context,R.color.black))
        }



    }
}