package com.example.lewords.localdata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lewords.model.word.Word

@Dao
interface WordDAO {
    @Insert
    fun addWord(word : Word)
    @Query("Select * From words limit :limitWord")
    fun getTodoList(limitWord : Int): LiveData<List<Word>>
}