package com.datechnologies.androidtest.data.network

import com.datechnologies.androidtest.data.responses.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ClientApi {
    //@FormUrlEncoded will encode our Field parameters
    //This POST request will return a response body of type LoginResponse
    @FormUrlEncoded
    @POST("login.php")
    suspend fun login(
            @Field("email") email: String,
            @Field("password") password: String
    ): Response<LoginResponse>
}