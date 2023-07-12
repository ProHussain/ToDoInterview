package com.todo.interview.adapter

import androidx.recyclerview.widget.RecyclerView
import com.todo.interview.databinding.ItemSaleBinding
import com.todo.interview.model.Sell

/**
 * Created by Hussain on 11/07/2023.
 * Purpose: This class is used to bind the data to the view holder
 */

class SellViewHolder(itemView: ItemSaleBinding) : RecyclerView.ViewHolder(itemView.root) {
    private val binding = itemView

    fun bindData(sellData: Sell) {
        binding.sell = sellData
    }
}