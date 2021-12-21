package com.datechnologies.androidtest.ui.fragments.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.datechnologies.androidtest.data.network.Wrapper
import com.datechnologies.androidtest.data.repository.ChatRepository
import com.datechnologies.androidtest.data.responses.ChatResponse
import kotlinx.coroutines.launch

//This class is a ViewModel to communicate between the repository and UI
//Repository being the Chat repository
class ChatViewModel(
        private val repository: ChatRepository
) : ViewModel() {
    // Because we want to control the data I create a backing property
    //val message is of type LiveData meaning its only readable
    //val _message is of type MutableLiveData meaning that the we can edit the data if need
    //because we only want the ViewModel to be able to edit the data and not the user
    //we set a getter to _message so the user gets a read only data
    //while the ViewModel is able to change the data if need be for example
    //filter out the results of the data so that the user only see clean data
    private val _message: MutableLiveData<Wrapper<ChatResponse>> = MutableLiveData()
    val message: LiveData<Wrapper<ChatResponse>>
        get() = _message

    fun getMessage() = viewModelScope.launch {
        //return the loading state
        _message.value = Wrapper.Loading
        //return the data for the success state
        _message.value = repository.getMessage()
    }
}