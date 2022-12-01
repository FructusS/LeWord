package com.example.lewords.model.word

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class Word(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "transcription") val transcription: String,
    @ColumnInfo(name = "wordoneng") val wordoneng: String,
    @ColumnInfo(name = "wordonrus") val wordonrus: String
)