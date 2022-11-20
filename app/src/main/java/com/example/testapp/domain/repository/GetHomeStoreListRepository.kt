package com.example.testapp.domain.repository

import com.example.testapp.data.api.RetrofitInstance
import com.example.testapp.domain.entity.BestSellerItem
import com.example.testapp.domain.entity.HomeStore
import retrofit2.Response

class GetHomeStoreListRepository {

    suspend fun getHomeStoreItem(): Response<HomeStore> {
        return RetrofitInstance.api.getHomeStore()
    }

}