package com.datechnologies.androidtest.data.repository

import com.datechnologies.androidtest.data.network.ChatApi
import com.datechnologies.androidtest.data.network.Wrapper
import com.datechnologies.androidtest.data.responses.ChatResponse

// This class is responsible for making the get request
//It takes in the api as a parameter
//Has a return of BaseRepository
class ChatRepository(
        private val api: ChatApi
) : BaseRepository() {
    //a suspend function returns a wrapper of Chat Response
    suspend fun getMessage(): Wrapper<ChatResponse> {
        //set wrapper equal to the results of safeapicall
        //and takes in the response as a parameter
        val wrapper = safeApiCall { api.getMessageResponse() }
        //then return the wrapper convertToDomain function located in Network wrapper
        return wrapper.convertToDomain()

    }


}