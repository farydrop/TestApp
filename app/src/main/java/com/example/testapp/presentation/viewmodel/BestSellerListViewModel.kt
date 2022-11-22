package com.example.testapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.domain.entity.HomeStore
import com.example.testapp.domain.repository.GetHomeStoreListRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class BestSellerListViewModel: ViewModel() {

    var repo = GetHomeStoreListRepository()
    val bestSellerList: MutableLiveData<Response<HomeStore>> = MutableLiveData()

    fun getBestSellerItem(){
        viewModelScope.launch {
            bestSellerList.value = repo.getHomeStoreItem()
        }
    }


}