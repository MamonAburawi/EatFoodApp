package com.mamon.eatfoodapp.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mamon.eatfoodapp.data.Category
import com.mamon.eatfoodapp.databinding.ItemCategoryBinding

class CategoryAdapter: ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(NoteDiffUtil()) {

    lateinit var listener: CategoryListener


    inner class CategoryViewHolder(private val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(data: Category){
            binding.category = data
            binding.btnCategory.setOnClickListener {
                listener.onClick(data)
            }

        }
    }


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val note = getItem(position)!!
        holder.bind(note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(inflater,parent,false)
        return CategoryViewHolder(binding)
    }


    class NoteDiffUtil : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Category, newItem: Category) = oldItem == newItem
    }



    interface CategoryListener {
        fun onClick(category: Category)
    }


}
