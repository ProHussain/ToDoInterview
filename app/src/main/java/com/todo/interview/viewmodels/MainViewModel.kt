package com.todo.interview.viewmodels

import android.app.Application
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import com.todo.interview.view.ToDoListActivity

/**
 * Created by Hussain on 11/07/2023.
 * ViewModel for MainActivity
 * How it works:
 * 1. When user clicks on any of the list, it will open ToDoListActivity
 * 2. It will pass the listType to ToDoListActivity
 * 3. ToDoListActivity will fetch the listType and will show the list accordingly
 */

class MainViewModel(application: Application) : AndroidViewModel(application) {

    fun onCallListClick() {
        val intent = Intent(getApplication(), ToDoListActivity::class.java)
        intent.putExtra("listType", "call")
        startActivity(getApplication(), intent, null)
    }

    fun onBuyListClick() {
        val intent = Intent(getApplication(), ToDoListActivity::class.java)
        intent.putExtra("listType", "buy")
        startActivity(getApplication(), intent, null)
    }

    fun onSaleListClick() {
        val intent = Intent(getApplication(), ToDoListActivity::class.java)
        intent.putExtra("listType", "sale")
        startActivity(getApplication(), intent, null)
    }
}