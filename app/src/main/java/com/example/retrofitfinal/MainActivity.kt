package com.example.retrofitfinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitfinal.databinding.ActivityMainBinding
import com.example.retrofitfinal.overview.OverviewViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        /**
         * Lazily initialize our [OverviewViewModel].
         */
        val viewModel: OverviewViewModel by lazy {
            ViewModelProvider(this)[OverviewViewModel::class.java]
        }
        viewModel.response.observe(this) {
            //Log.i("post",it[1].toString())
            binding.textView.text = it[1].toString()
        }
    }
}