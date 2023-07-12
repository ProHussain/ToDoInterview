package com.todo.interview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.todo.interview.databinding.ItemBuyBinding
import com.todo.interview.databinding.ItemCallBinding
import com.todo.interview.databinding.ItemSaleBinding
import com.todo.interview.model.BuyData
import com.todo.interview.model.CallData
import com.todo.interview.model.Sell

/**
 * Created by Hussain on 11/07/2023.
 * Generic Adapter for all three lists
 * How it works:
 * 1. It takes a list of Any type
 * 2. It checks the type of the list item and inflates the corresponding layout
 * 3. It binds the data to the layout
 * 4. It updates the list when the list is updated
 * 5. It has three view holders for each type of list
 * 6. It has three layouts for each type of list
 * 7. It has three data classes for each type of list
 */

class GenericAdapter () : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list:List<Any> = ArrayList()

    public fun updateList(list:List<Any>) {
        this.list = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            1 -> {
                val binding: ItemCallBinding = ItemCallBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CallViewHolder(binding)
            }
            2 -> {
                val binding: ItemBuyBinding = ItemBuyBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return BuyViewHolder(binding)
            }
            3 -> {
                val binding: ItemSaleBinding = ItemSaleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return SellViewHolder(binding)
            }
        }
        return super.createViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (list[position]) {
            is CallData -> {
                val callData = list[position] as CallData
                (holder as CallViewHolder).bindData(callData)
            }
            is BuyData -> {
                val buyData = list[position] as BuyData
                (holder as BuyViewHolder).bindData(buyData)
            }
            is Sell -> {
                val sellData = list[position] as Sell
                (holder as SellViewHolder).bindData(sellData)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        when (list[position]) {
            is CallData -> return 1
            is BuyData -> return 2
            is Sell -> return 3
        }
        return super.getItemViewType(position)
    }
}