package com.example.testapp.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.domain.entity.Category

interface CategoryActionListener {
    fun onChangeEnableState(category: Category)
}

class CategoryListAdapter(private val categoryList: ArrayList<Category>, private var actionListener: CategoryActionListener): RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder>(), View.OnClickListener {


    class CategoryListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ellipse = view.findViewById<LinearLayout>(R.id.ellipse)
        val categoryPicture = view.findViewById<ImageView>(R.id.iv_picture)
        val categoryTitle = view.findViewById<TextView>(R.id.tv_title)
    }

    override fun onClick(view: View) {
        val category = view.tag as Category
        actionListener.onChangeEnableState(category)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item_enabled, parent, false)
        view.setOnClickListener(this)
        return CategoryListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        val currentItem = categoryList[position]
        holder.categoryPicture.setImageResource(currentItem.picture)
        holder.categoryTitle.text = currentItem.title

        holder.itemView.tag = currentItem
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }


}