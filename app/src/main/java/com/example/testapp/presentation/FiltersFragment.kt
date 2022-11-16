package com.example.testapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testapp.R
import com.example.testapp.databinding.FragmentFiltersBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.lang.RuntimeException


class FiltersFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentFiltersBinding? = null
    val binding: FragmentFiltersBinding
        get() = _binding ?: throw RuntimeException("FragmentFiltersBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFiltersBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FiltersFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}