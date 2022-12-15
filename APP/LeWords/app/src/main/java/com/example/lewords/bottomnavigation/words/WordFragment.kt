package com.example.lewords.bottomnavigation.words


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lewords.bottomnavigation.words.adapters.WordListAdapter
import com.example.lewords.databinding.FragmentWordBinding
import com.example.lewords.model.word.Word
import com.example.lewords.utils.WordsSwipeCallback


class WordFragment : Fragment() , WordListAdapter.IWordListener {

    private lateinit var viewModel: WordViewModel
    private var _binding: FragmentWordBinding? = null
    private val binding get() = _binding!!
    private lateinit var todoAdapter: WordListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[WordViewModel::class.java]




        binding.wordRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        todoAdapter = WordListAdapter(this)
        ItemTouchHelper(WordsSwipeCallback(todoAdapter,requireContext())).attachToRecyclerView(binding.wordRecyclerView)
        binding.wordRecyclerView.adapter = todoAdapter
        viewModel.words.observe(viewLifecycleOwner){
            todoAdapter.submitList(it)
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemSwipeRight(word: Word, position: Int) {

        viewModel.saveWord(word)

    }

    override fun onItemSwipeLeft(word: Word, position: Int) {


        try {
            Log.i("123", "left swipe $word")
            word.learned = true;
            viewModel.saveWord(word)

        }catch (e : Exception){
            Log.i("123",e.message.toString())
        }

    }
}