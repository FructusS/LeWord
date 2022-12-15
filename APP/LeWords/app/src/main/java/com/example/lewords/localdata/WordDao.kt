package com.example.lewords.localdata

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.lewords.model.word.Word

@Dao
interface WordDao {
    @Insert
    fun saveWord(word : Word)
    @Query("Select * From words where learned = 0 limit :limitWord")
    fun getNotLearnedWords(limitWord : Int): LiveData<List<Word>>
    @Query("Select * From words where learned = 1 limit :limitWord")
    fun getLearnedWords(limitWord : Int): LiveData<List<Word>>
    @Update
    fun rememberWord(word: Word)
}