package com.datechnologies.androidtest.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.datechnologies.androidtest.data.network.ClientApi
import com.datechnologies.androidtest.data.network.Wrapper
import com.datechnologies.androidtest.data.repository.LoginRepository
import com.datechnologies.androidtest.databinding.FragmentLoginBinding
import com.datechnologies.androidtest.ui.activity.MainActivity
import com.datechnologies.androidtest.ui.enable
import com.datechnologies.androidtest.ui.fragments.base.BaseFragmentApi
import com.datechnologies.androidtest.ui.fragments.base.LoginViewModel
import com.datechnologies.androidtest.ui.handleApiError
import com.datechnologies.androidtest.ui.startNewActivity
import com.datechnologies.androidtest.ui.visible
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch


class LoginFragment : BaseFragmentApi<LoginViewModel, FragmentLoginBinding, LoginRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLogin.enable(false)
        val imm: InputMethodManager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager


        viewModel.loginResponse.observe(viewLifecycleOwner, {

            when (it) {
                is Wrapper.Success -> {
                    lifecycleScope.launch {
                        context?.let { it1 ->
                            MaterialAlertDialogBuilder(it1)
                                    .setTitle(it.value.code)
                                    .setMessage(it.value.message + "\n" + "Time it took to receive response: " + it.networkCallDuration + " milliseconds")
                                    .setPositiveButton("Okay") { _, _ ->
                                        requireActivity().startNewActivity(MainActivity::class.java)
                                    }
                                    .show()
                        }
                    }
                }
                is Wrapper.Failure -> handleApiError(it) { login() }
                else -> Wrapper.Loading
            }
        })

        binding.editTextTextEmailAddress.addTextChangedListener {
            val email = binding.editTextTextEmailAddress.text.toString().trim()
            binding.buttonLogin.enable(email.isNotEmpty() && it.toString().trim().isNotEmpty())
        }

        binding.buttonLogin.setOnClickListener {
            login()
            imm.hideSoftInputFromWindow(requireView().windowToken, 0)
        }

    }

    private fun login() {
        val email = binding.editTextTextEmailAddress.text.toString().trim()
        val password = binding.editTextTextPassword.text.toString().trim()
        viewModel.login(email, password)

    }

    override fun getViewModel() = LoginViewModel::class.java

    override fun getFragmentBinding(
            inflater: LayoutInflater,
            container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = LoginRepository(retrofitBuilder.buildApi(ClientApi::class.java))

}