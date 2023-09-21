package com.example.quotesapp.ui

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.databinding.ActivityAddQuoteBinding
import com.example.quotesapp.model.QuotesModel
import com.example.quotesapp.viewmodel.QuotesViewModel
import kotlinx.coroutines.launch

class AddQuoteActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddQuoteBinding
    lateinit var viewModel:QuotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel  = ViewModelProvider(this).get(QuotesViewModel::class.java)

        addFocusToEditText()
        binding.addQuoteBtn.setOnClickListener {
            addQuote()
        }
        binding.dismissBtn.setOnClickListener {
            finish()
        }
    }

    private fun addQuote() {
        val quote = binding.quoteText.text
        val quotesModel  = QuotesModel(author = "Jane Doe", quotes = quote.toString())
        viewModel.viewModelScope.launch {
            viewModel.addQuotes(quotesModel)
            finish()
        }
    }

    private fun addFocusToEditText() {
        binding.quoteText.background = null
        binding.quoteText.requestFocus()
        val imm: InputMethodManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }
}