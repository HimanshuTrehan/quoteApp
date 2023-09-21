package com.example.quotesapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quotesapp.dao.QuotesDao
import com.example.quotesapp.model.QuotesModel

@Database(entities = [QuotesModel::class], version = 1)

abstract class QuoteDataBase:RoomDatabase() {
    abstract fun getQuoteDao():QuotesDao

    companion object {
        @Volatile
        private var INSTANCE:QuoteDataBase? = null
        fun getDatabase(context: Context):QuoteDataBase
        {
            if(INSTANCE==null)
            {
                synchronized(this)
                {
                    INSTANCE = setupDatabase(context)
                }
            }

            return INSTANCE!!
        }

        private fun setupDatabase(context: Context):QuoteDataBase {

            return Room.databaseBuilder(context,QuoteDataBase::class.java,"QuoteDB").build()

        }


    }

}