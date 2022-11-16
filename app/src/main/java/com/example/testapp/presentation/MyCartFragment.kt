package com.example.testapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testapp.R
import com.example.testapp.databinding.FragmentMyCartBinding
import java.lang.RuntimeException


class MyCartFragment : Fragment() {

    private var _binding: FragmentMyCartBinding? = null
    val binding: FragmentMyCartBinding
        get() = _binding ?: throw RuntimeException("FragmentMyCartBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyCartBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyCartFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}