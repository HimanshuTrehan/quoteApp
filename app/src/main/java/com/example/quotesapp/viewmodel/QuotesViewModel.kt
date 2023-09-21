package com.example.quotesapp.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.quotesapp.dao.QuotesDao
import com.example.quotesapp.db.QuoteDataBase
import com.example.quotesapp.model.QuotesModel
import com.example.quotesapp.repository.QuotesRepository

class QuotesViewModel( application: Application):AndroidViewModel(application) {

    private var quotesDao: QuotesDao = QuoteDataBase.getDatabase(application.applicationContext).getQuoteDao()
    private var respository:QuotesRepository = QuotesRepository(quotesDao)

    private lateinit var list: LiveData<List<QuotesModel>>
    private var index = 0



    suspend fun addQuotes(quotesModel: QuotesModel)
    {
        respository.addQuotes(quotesModel)
    }

     fun getQuotesData():LiveData<List<QuotesModel>>
    {
        list = respository.getQuotes()
        return list
    }

    fun nextQuote():QuotesModel?
    {
        if (list.value != null && index < list.value!!.size-1 ) {
            ++index
        }
        return list.value?.get(index)
    }
    fun prevQuote():QuotesModel?
    {
        if (list.value != null && index>0) {
            --index
        }
        return list.value?.get(index)

    }
    fun getQuote(): QuotesModel? {

        return list.value?.get(index = index)
    }


}