package com.example.lewords.bottomnavigation.words.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lewords.databinding.WordRecyclerviewItemBinding
import com.example.lewords.model.word.Word

class WordListAdapter : ListAdapter<Word,WordListAdapter.WordViewHolder>(WordViewHolder.WordComparator()){
    class WordViewHolder(private val binding : WordRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun  bind(word : Word){
            binding.word.text = word.wordoneng
        }

        class WordComparator : DiffUtil.ItemCallback<Word>(){
            override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem.id == newItem.id
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = WordRecyclerviewItemBinding.inflate(inflater, parent, false)


        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = getItem(position)

        holder.bind(word)
    }

}
