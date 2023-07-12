package com.todo.interview.adapter

import androidx.recyclerview.widget.RecyclerView
import com.todo.interview.databinding.ItemCallBinding
import com.todo.interview.model.CallData

/**
 * Created by Hussain on 11/07/2023.
 * Purpose: This class is used to bind the data to the view holder
 */

class CallViewHolder(itemView: ItemCallBinding) : RecyclerView.ViewHolder(itemView.root) {
    private val binding = itemView

    fun bindData(callData:CallData) {
        binding.call = callData
    }
}