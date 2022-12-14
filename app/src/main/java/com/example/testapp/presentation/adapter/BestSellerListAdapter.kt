package com.example.testapp.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.domain.entity.BestSellerItem
import com.squareup.picasso.Picasso

class BestSellerListAdapter: RecyclerView.Adapter<BestSellerListAdapter.BestSellerItemViewHolder>() {

    var listStart = emptyList<BestSellerItem>()

    class BestSellerItemViewHolder(view: View):RecyclerView.ViewHolder(view){
        val discountPrice: TextView = view.findViewById<TextView>(R.id.discount_price)
        val priceWithoutDiscount: TextView = view.findViewById<TextView>(R.id.price_without_discount)
        val title: TextView = view.findViewById<TextView>(R.id.title)
        val picture = view.findViewById<ImageView>(R.id.picture)
        val isFavorites = view.findViewById<ImageView>(R.id.favorites)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_seller_item,parent,false)
        return BestSellerItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestSellerItemViewHolder, position: Int) {
        holder.discountPrice.text = listStart[position].discount_price.toString()
        holder.priceWithoutDiscount.text = listStart[position].price_without_discount.toString()
        holder.title.text = listStart[position].title

        Picasso.with(holder.picture.context)
            .load(listStart[position].picture)
            .into(holder.picture)

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


