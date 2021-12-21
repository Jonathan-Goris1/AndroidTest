package com.datechnologies.androidtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.datechnologies.androidtest.databinding.FragmentMainBinding
import com.datechnologies.androidtest.ui.activity.AnimationActivity
import com.datechnologies.androidtest.ui.activity.ChatActivity
import com.datechnologies.androidtest.ui.activity.LoginActivity
import com.datechnologies.androidtest.ui.fragments.base.BaseFragment
import com.datechnologies.androidtest.ui.startAnotherActivity


class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonChat.setOnClickListener {
            requireActivity().startAnotherActivity(ChatActivity::class.java)
        }
        binding.buttonLogin.setOnClickListener {
            requireActivity().startAnotherActivity(LoginActivity::class.java)
        }
        binding.buttonAnimation.setOnClickListener {
            requireActivity().startAnotherActivity(AnimationActivity::class.java)
        }
    }

    override fun getFragmentBinding(
            inflater: LayoutInflater,
            container: ViewGroup?
    ) = FragmentMainBinding.inflate(inflater, container, false)


}