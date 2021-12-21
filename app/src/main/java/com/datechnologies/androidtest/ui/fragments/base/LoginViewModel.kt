package com.datechnologies.androidtest.ui.fragments.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.datechnologies.androidtest.data.network.Wrapper
import com.datechnologies.androidtest.data.repository.LoginRepository
import com.datechnologies.androidtest.data.responses.LoginResponse
import kotlinx.coroutines.launch

//This class is a ViewModel to communicate between the repository and UI
//Repository being the Login repository
class LoginViewModel(
        private val repository: LoginRepository
) : ViewModel() {
    //Because we want to control the data I create a backing property
    //val loginResponse is of type LiveData meaning its only readable
    //val _loginResponse is of type MutableLiveData meaning that the we can edit the data if need
    //because we only want the ViewModel to be able to edit the data and not the user
    //we set a getter to _loginResponse so the user gets a read only data
    //while the ViewModel is able to change the data if need be for example
    //filter out the results of the data so that the user only see clean data

    private val _loginResponse: MutableLiveData<Wrapper<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Wrapper<LoginResponse>>
        get() = _loginResponse

    fun login(email: String, password: String) = viewModelScope.launch {
        _loginResponse.value = repository.login(email, password)


    }


}