package com.example.quotesapp.repository

import androidx.lifecycle.LiveData
import androidx.room.Insert
import com.example.quotesapp.dao.QuotesDao
import com.example.quotesapp.db.QuoteDataBase
import com.example.quotesapp.model.QuotesModel

class QuotesRepository(private var dao: QuotesDao) {


    suspend fun addQuotes(quotesModel: QuotesModel){
       return dao.addQuotes(quotesModel)
    }

    fun getQuotes():LiveData<List<QuotesModel>>
    {
        return dao.getQuotes()
    }


}