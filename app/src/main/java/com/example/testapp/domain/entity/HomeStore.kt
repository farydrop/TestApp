package com.example.testapp.domain.entity

import com.google.gson.annotations.SerializedName

data class HomeStore(
    @SerializedName(value = "home_store")
    val homeStore: List<HotSales>,

    @SerializedName(value = "best_seller")
    val bestSeller: List<BestSellerItem>
)
