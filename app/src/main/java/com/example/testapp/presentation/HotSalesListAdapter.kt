package com.example.testapp.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.domain.entity.BestSellerItem
import com.example.testapp.domain.entity.HotSales
import com.squareup.picasso.Picasso

class HotSalesListAdapter: RecyclerView.Adapter<HotSalesListAdapter.HotSalesListViewHolder>() {

    var hotSalesList = emptyList<HotSales>()

    class HotSalesListViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val picture = view.findViewById<ImageView>(R.id.hs_picture)
        val title = view.findViewById<TextView>(R.id.hs_title)
        val subtitle = view.findViewById<TextView>(R.id.hs_subtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hot_sales_item,parent,false)
        return HotSalesListViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotSalesListViewHolder, position: Int) {
        holder.title.text = hotSalesList[position].title
        holder.subtitle.text = hotSalesList[position].subtitle
        Picasso.with(holder.picture.context)
            .load(hotSalesList[position].picture)
            .into(holder.picture)
    }

    override fun getItemCount(): Int {
        return hotSalesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setlist(list: List<HotSales>){
        hotSalesList = list
        notifyDataSetChanged()
    }
}