package com.datechnologies.androidtest.ui.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

//This abstract class will extends any fragments that
//will only display UI to the user
abstract class BaseFragment<B : ViewBinding> : Fragment() {
    //Since we are using viewbinding we can override the onCreateView
    //to take in a binding xml class
    protected lateinit var binding: B

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)
        return binding.root
    }

    //This function will be called in all fragments to set the binding view layout
    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B

}