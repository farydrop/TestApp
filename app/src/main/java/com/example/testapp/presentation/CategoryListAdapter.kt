package com.example.testapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.domain.entity.Category

class CategoryListAdapter(private val categoryList: ArrayList<Category>): RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder>() {

    class CategoryListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val categoryPicture = view.findViewById<ImageView>(R.id.iv_picture)
        val categoryTitle = view.findViewById<TextView>(R.id.tv_title)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return CategoryListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        val currentItem = categoryList[position]
        holder.categoryPicture.setImageResource(currentItem.picture)
        holder.categoryTitle.text = currentItem.title
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}