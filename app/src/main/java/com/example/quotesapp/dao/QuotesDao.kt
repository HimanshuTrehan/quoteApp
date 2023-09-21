package com.example.quotesapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quotesapp.model.QuotesModel

@Dao
interface QuotesDao {

    @Insert
    suspend fun addQuotes(quotesModel: QuotesModel)


    @Query("SELECT * FROM QuotesTable")
    fun getQuotes():LiveData<List<QuotesModel>>




}