package com.mamon.eatfoodapp.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mamon.eatfoodapp.data.Food
import com.mamon.eatfoodapp.databinding.ItemFoodBinding


class FoodAdapter: ListAdapter<Food, FoodAdapter.FoodViewHolder>(NoteDiffUtil()) {

    lateinit var listener: FoodListener

    inner class FoodViewHolder(private val binding: ItemFoodBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(data: Food){
            binding.food = data
            binding.btnItemFood.setOnClickListener {
                listener.onClick(data)
            }

        }
    }


    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val note = getItem(position)!!
        holder.bind(note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFoodBinding.inflate(inflater,parent,false)
        return FoodViewHolder(binding)
    }


    class NoteDiffUtil : DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Food, newItem: Food) = oldItem == newItem
    }


    interface FoodListener {
        fun onClick(food: Food)
    }


}
