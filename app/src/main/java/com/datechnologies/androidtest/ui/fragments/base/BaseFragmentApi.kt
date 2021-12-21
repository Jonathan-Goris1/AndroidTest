package com.datechnologies.androidtest.ui.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.datechnologies.androidtest.data.network.RetrofitBuilder
import com.datechnologies.androidtest.data.repository.BaseRepository

//This class will extend any fragments that implement an api
//They will need a reference to the binding class, repository and VIewModel
abstract class BaseFragmentApi<VM : ViewModel, B : ViewBinding, R : BaseRepository> : Fragment() {


    protected lateinit var binding: B
    protected lateinit var viewModel: VM
    protected val retrofitBuilder = RetrofitBuilder()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())
        return binding.root
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B

    abstract fun getFragmentRepository(): R

}