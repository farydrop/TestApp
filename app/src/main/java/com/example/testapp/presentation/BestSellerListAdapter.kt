package com.example.testapp.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.domain.entity.BestSellerItem

class BestSellerListAdapter: RecyclerView.Adapter<BestSellerListAdapter.BestSellerItemViewHolder>() {

    var listStart = emptyList<BestSellerItem>()

    class BestSellerItemViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_seller_item,parent,false)
        return BestSellerItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestSellerItemViewHolder, position: Int) {
        holder.itemView.disco.text = listStart[position].ccy
        holder.itemView.item_buy.text = listStart[position].buy
        holder.itemView.item_sale.text = listStart[position].sale
    }

    override fun getItemCount(): Int {
        return listStart.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setlist(list: List<BestSellerItem>){
        listStart = list
        notifyDataSetChanged()
    }


    /*var list = emptyList<BestSellerItem>()

    class BestSellerItemViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_seller_item,parent,false)
        return BestSellerItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestSellerItemViewHolder, position: Int) {
        holder.itemView. = list[position].discountPrice
    }

    override fun getItemCount(): Int {
        return list.size
    }*/
}


