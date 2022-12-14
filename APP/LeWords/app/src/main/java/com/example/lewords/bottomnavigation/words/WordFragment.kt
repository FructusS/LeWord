package com.example.lewords.bottomnavigation.words


import android.os.Bundle
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


class WordFragment : Fragment() {

    private lateinit var viewModel: WordViewModel
    private var _binding: FragmentWordBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    private lateinit var todoAdapter: WordListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordBinding.inflate(inflater, container, false)
        binding.wordRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        todoAdapter = WordListAdapter()
        todoAdapter.submitList(initData())

        ItemTouchHelper(WordsSwipeCallback(todoAdapter,requireContext())).attachToRecyclerView(binding.wordRecyclerView)
        binding.wordRecyclerView.adapter = todoAdapter

        return binding.root

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[WordViewModel::class.java]

        // TODO: Use the ViewModel
    }

    private fun initData(): List<Word> {
        val words : ArrayList<Word> = arrayListOf()
        words.add(Word(null,"test1","test1","test1"))
        words.add(Word(null,"test2","test2","test2"))
        words.add(Word(null,"test3","test3","test3"))
        words.add(Word(null,"test4","test4","test4"))
        words.add(Word(null,"test5","test5","test5"))
        return words
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}