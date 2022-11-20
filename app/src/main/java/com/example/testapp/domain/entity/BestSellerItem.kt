package com.example.testapp.domain.entity

import com.google.gson.annotations.SerializedName

data class BestSellerItem(
    val id: Int,
    val is_favorites: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
)
