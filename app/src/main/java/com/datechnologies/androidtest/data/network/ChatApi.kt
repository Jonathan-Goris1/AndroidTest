package com.datechnologies.androidtest.data.network

import com.datechnologies.androidtest.data.responses.ChatResponse
import retrofit2.Response
import retrofit2.http.GET

interface ChatApi {
    //This retrofit GET request function will return a response body of type ChatResponse
    @GET("chat_log.php")
    suspend fun getMessageResponse(): Response<ChatResponse>
}