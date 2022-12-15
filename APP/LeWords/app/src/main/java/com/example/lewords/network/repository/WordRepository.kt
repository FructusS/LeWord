package com.example.lewords.network.repository

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.lewords.localdata.LocalDataBase
import com.example.lewords.localdata.WordDao
import com.example.lewords.model.word.Word
import com.example.lewords.network.interfaces.IWordApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class WordRepository(application: Application) {
    private val wordDao : WordDao

    init {

        val db = LocalDataBase.getDatabase(application.applicationContext)
        wordDao = db.wordDao()
    }
    suspend fun getWord(countWords: Int) : Response<List<Word>>?{
        return IWordApi.getWordApi()?.getWords(countWord = countWords)
    }

    fun rememberWord(word: Word) = runBlocking{
        this.launch(Dispatchers.IO) {

            wordDao.rememberWord(word)
        }
    }
    fun saveWord(word: Word) = runBlocking{
        this.launch(Dispatchers.IO) {

            wordDao.saveWord(word)
        }
    }

}