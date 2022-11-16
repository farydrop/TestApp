package com.example.testapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testapp.R
import com.example.testapp.databinding.FragmentHomeStoreBinding
import com.example.testapp.databinding.FragmentSplashBinding
import java.lang.RuntimeException


class HomeStoreFragment : Fragment() {

    private var _binding: FragmentHomeStoreBinding? = null
    val binding: FragmentHomeStoreBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeStoreBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeStoreBinding.inflate(inflater,container,false)
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