package com.example.testapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.domain.entity.HomeStore
import com.example.testapp.domain.repository.GetHomeStoreListRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class HotSalesListViewModel: ViewModel() {

    var repo = GetHomeStoreListRepository()
    val hotSalesList: MutableLiveData<Response<HomeStore>> = MutableLiveData()

    fun getHotSalesItem(){
        viewModelScope.launch {
            hotSalesList.value = repo.getHomeStoreItem()
        }
    }

}