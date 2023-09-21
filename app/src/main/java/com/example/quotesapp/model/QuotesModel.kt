package com.example.quotesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "QuotesTable")
data class QuotesModel(
    @PrimaryKey(autoGenerate = true)
    val id:Long=0,
    val author:String ="",
    val quotes:String =""
)