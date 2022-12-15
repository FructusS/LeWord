package com.example.lewords.bottomnavigation.words

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.lewords.model.word.Word
import com.example.lewords.network.repository.WordRepository
import com.example.lewords.utils.SessionManager
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : WordRepository = WordRepository(application)
    val words : MutableLiveData<List<Word>> =  MutableLiveData()

    init {
        viewModelScope.launch {
            val getResponse = repository.getWord(countWords = 10)

            if (getResponse?.code() == 200){
                words.postValue(getResponse.body())
            }
        }
    }
//    fun rememberWord(word: Word){
//        word.id = null
//        word.learned = true
//        repository.rememberWord(word)
//    }
    fun saveWord(word: Word){
        word.id = null
        repository.saveWord(word)
    }
}