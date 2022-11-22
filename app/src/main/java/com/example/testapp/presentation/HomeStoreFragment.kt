package com.example.testapp.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.databinding.FragmentHomeStoreBinding
import com.example.testapp.domain.entity.Category
import com.example.testapp.presentation.adapter.BestSellerListAdapter
import com.example.testapp.presentation.adapter.HotSalesListAdapter
import com.example.testapp.presentation.viewmodel.BestSellerListViewModel
import com.example.testapp.presentation.viewmodel.HotSalesListViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.RuntimeException


class HomeStoreFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bestSellerListAdapter: BestSellerListAdapter
    private lateinit var hotSalesListAdapter: HotSalesListAdapter
    private lateinit var categoryListAdapter: CategoryListAdapter
    lateinit var categoryArrayList: ArrayList<Category>
    lateinit var imageId: Array<Int>
    lateinit var title: Array<String>
    private lateinit var homeBottomNavigation: BottomNavigationView



    private var _binding: FragmentHomeStoreBinding? = null
    val binding: FragmentHomeStoreBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeStoreBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        imageId = arrayOf(
            R.drawable.ic_phones,
            R.drawable.ic_computer,
            R.drawable.ic_health,
            R.drawable.ic_books
        )

        title = arrayOf(
            "Phones",
            "Computer",
            "Health",
            "Books"
        )

        categoryArrayList = arrayListOf<Category>()
        getUserData()

        val bestSellersViewModel = ViewModelProvider(this)[BestSellerListViewModel::class.java]
        val hotSalesViewModel = ViewModelProvider(this)[HotSalesListViewModel::class.java]
        _binding = FragmentHomeStoreBinding.inflate(inflater,container,false)

        homeBottomNavigation = binding.bottomNavigationMain
        homeBottomNavigation.itemIconTintList = null
        homeBottomNavigation.setOnClickListener{

        }

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

        recyclerView = binding.rvCategory
        categoryListAdapter = CategoryListAdapter(categoryArrayList, object: CategoryActionListener{
            @SuppressLint("ResourceAsColor")
            override fun onChangeEnableState(category: Category) {
                /*val ellipse = view?.findViewById<LinearLayout>(R.id.ellipse)
                ellipse?.backgroundTintMode

                val tvTitle = view?.findViewById<TextView>(R.id.tv_title)
                title[1] = "dddd"*/
            }
        })
        recyclerView.adapter = categoryListAdapter

        return binding.root
    }

    private fun getUserData() {
        for (i in imageId.indices){
            val category = Category(imageId[i],title[i])
            categoryArrayList.add(category)
        }
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