package com.example.quotesapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.quotesapp.databinding.ActivityMainBinding
import com.example.quotesapp.model.QuotesModel
import com.example.quotesapp.viewmodel.QuotesViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: QuotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel  = ViewModelProvider(this).get(QuotesViewModel::class.java)
        binding.addQuoteBtn.setOnClickListener {
            val intent  =Intent(applicationContext,AddQuoteActivity::class.java)
            startActivity(intent)
        }
        val quotesModel = viewModel.getQuotesData();
        quotesModel.observe(this){
            if (it!=null)
            {
                setQuotes(it.get(0))
            }
        }


            binding.nextBtn.setOnClickListener {
                setQuotes(viewModel.nextQuote())
            }
        binding.prevBtn.setOnClickListener {
            setQuotes(viewModel.prevQuote())
        }


    }

    private fun setQuotes(quotesModel: QuotesModel?) {

        binding.quoteText.text = quotesModel?.quotes ?: ""
        binding.authorText.text = quotesModel?.author ?: ""
    }


}