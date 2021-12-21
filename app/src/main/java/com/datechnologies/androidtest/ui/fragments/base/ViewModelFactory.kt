package com.datechnologies.androidtest.ui.fragments.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.datechnologies.androidtest.data.repository.BaseRepository
import com.datechnologies.androidtest.data.repository.ChatRepository
import com.datechnologies.androidtest.data.repository.LoginRepository

//This ViewModelFactory class will in charge of instantiating all the ViewModel
//classes in the project
//every ViewModel created must have a ModelClass declared here or
//the app with not be able to find the ViewModel
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
        private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {
    //
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository as LoginRepository) as T
            modelClass.isAssignableFrom(ChatViewModel::class.java) -> ChatViewModel(repository as ChatRepository) as T
            else -> throw IllegalArgumentException("ViewModel Class Not Found")

        }
    }
}


