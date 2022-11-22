package com.example.testapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testapp.R
import com.example.testapp.databinding.FragmentSplashBinding
import kotlinx.coroutines.*
import java.lang.RuntimeException
import kotlin.coroutines.CoroutineContext


class SplashFragment : Fragment()/*, CoroutineScope*/ {

    /*override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()*/

    private var _binding: FragmentSplashBinding? = null
    val binding: FragmentSplashBinding
        get() = _binding ?: throw RuntimeException("FragmentSplashBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        *//*launch {
            delay(3000)
            withContext(Dispatchers.Main){
                (activity as HomeStoreFragment)
            }
        }*//*
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
