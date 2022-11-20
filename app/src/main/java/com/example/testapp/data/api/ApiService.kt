package com.example.testapp.data.api

import com.example.testapp.domain.entity.BestSellerItem
import com.example.testapp.domain.entity.HomeStore
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHomeStore(): Response<HomeStore>


}