package com.example.lewords.localdata

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.lewords.model.word.Word

@Database(entities = [Word::class] ,version = 2)
abstract class LocalDataBase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object{
        @Volatile
        private var INSTANCE: LocalDataBase? = null

        fun getDatabase(context: Context): LocalDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDataBase::class.java,
                    "local_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}