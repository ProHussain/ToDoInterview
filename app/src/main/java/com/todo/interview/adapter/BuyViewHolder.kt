package com.todo.interview.adapter

import androidx.recyclerview.widget.RecyclerView
import com.todo.interview.databinding.ItemBuyBinding
import com.todo.interview.model.BuyData

/**
 * Created by Hussain on 11/07/2023.
 * Purpose: This class is used to bind the data to the view holder
 * and display it in the recycler view
 */

class BuyViewHolder(itemView: ItemBuyBinding) : RecyclerView.ViewHolder(itemView.root) {
    private val binding: ItemBuyBinding = itemView

    fun bindData(buyData: BuyData) {
        binding.buy = buyData
    }
}