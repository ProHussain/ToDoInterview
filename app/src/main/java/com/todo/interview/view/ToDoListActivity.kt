package com.todo.interview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.todo.interview.R
import com.todo.interview.adapter.GenericAdapter
import com.todo.interview.databinding.ActivityTodoListBinding
import com.todo.interview.viewmodels.ToDoListViewModel

/**
 * Created by Hussain on 11/07/2023.
 * How it works:-
 * 1. This activity is used to show the list of data.
 * 2. It is used to show the list of data based on the type of list.
 * 3. For example, if the listType is "call", then it will show the list of call data from the API.
 * 4. If the listType is "buy", then it will show the list of buy data from the API.
 * 5. If the listType is "sell", then it will show the list of sell data from the ROOM.
 * 6. The listType is passed from the MainActivity.
 */

class ToDoListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoListBinding
    private lateinit var viewModel: ToDoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_todo_list)
        viewModel = ToDoListViewModel(application)
        binding.lifecycleOwner = this

        val listType = intent.getStringExtra("listType")
        Log.e("listType", listType?:"Error")
        viewModel.loadList(listType?:"")
        binding.todoList.adapter = GenericAdapter()

        viewModel.callDataList.observe(this) {
            val adapter: GenericAdapter = binding.todoList.adapter as GenericAdapter
            adapter.updateList(it)
        }

        viewModel.buyDataList.observe(this) {
            val adapter: GenericAdapter = binding.todoList.adapter as GenericAdapter
            adapter.updateList(it)
        }

        viewModel.sellDataList.observe(this) {
            val adapter: GenericAdapter = binding.todoList.adapter as GenericAdapter
            adapter.updateList(it)
        }
    }
}