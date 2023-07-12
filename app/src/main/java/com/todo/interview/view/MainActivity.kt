package com.todo.interview.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.todo.interview.R
import com.todo.interview.databinding.ActivityMainBinding
import com.todo.interview.viewmodels.MainViewModel

/**
 * Created by Hussain on 11/07/2023.
 * Main Activity to show three buttons
 * 1. Call List
 * 2. Buy List
 * 3. Sell List
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}