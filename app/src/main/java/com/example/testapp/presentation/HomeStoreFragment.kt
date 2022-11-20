package com.example.testapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.databinding.FragmentHomeStoreBinding
import com.example.testapp.databinding.FragmentSplashBinding
import java.lang.RuntimeException


class HomeStoreFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var bestSellerListAdapter: BestSellerListAdapter
    lateinit var hotSalesListAdapter: HotSalesListAdapter

    private var _binding: FragmentHomeStoreBinding? = null
    val binding: FragmentHomeStoreBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeStoreBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bestSellersViewModel = ViewModelProvider(this)[BestSellerListViewModel::class.java]
        val hotSalesViewModel = ViewModelProvider(this)[HotSalesListViewModel::class.java]
        _binding = FragmentHomeStoreBinding.inflate(inflater,container,false)

        recyclerView = binding.rvBestSeller
        bestSellerListAdapter = BestSellerListAdapter()
        recyclerView.adapter = bestSellerListAdapter
        bestSellersViewModel.getBestSellerItem()
        bestSellersViewModel.bestSellerList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { bestSellerListAdapter.setlist(it.bestSeller) }
        }

        recyclerView = binding.rvHotSales
        hotSalesListAdapter = HotSalesListAdapter()
        recyclerView.adapter = hotSalesListAdapter
        hotSalesViewModel.getHotSalesItem()
        hotSalesViewModel.hotSalesList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { hotSalesListAdapter.setlist(it.homeStore) }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeStoreFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}