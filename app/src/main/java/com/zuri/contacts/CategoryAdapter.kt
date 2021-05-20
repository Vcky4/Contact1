package com.zuri.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zuri.contacts.databinding.CategoryBinding
import com.zuri.contacts.databinding.ContactItemBinding

class CategoryAdapter(private val onContactClick:Clicks):RecyclerView.Adapter<CategoryAdapter.CategoryViewholder>() {

    private val categories = mutableListOf<Category>()

    inner class CategoryViewholder(private val binding: CategoryBinding):RecyclerView.ViewHolder(binding.root){
        fun bindItem(category: Category){
            binding.categoryText.text = category.categoryName

        }val cardTitle:TextView=binding.categoryText

    }
    fun setupCategory(category: List<Category>){
        this.categories.addAll(category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewholder {
        return CategoryViewholder(
                CategoryBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewholder, position: Int) {
        val category = categories[position]
        holder.bindItem(category)

        holder.cardTitle.setOnClickListener {
            onContactClick.onClick(category.categoryName)
      }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}


