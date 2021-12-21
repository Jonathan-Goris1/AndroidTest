package com.datechnologies.androidtest.data.repository

import com.datechnologies.androidtest.data.network.ClientApi
import com.datechnologies.androidtest.data.network.Wrapper
import com.datechnologies.androidtest.data.responses.LoginResponse

// This class is responsible for making the post request
//It takes in the api as a parameter
//Has a return of BaseRepository
class LoginRepository(
        private val api: ClientApi
) : BaseRepository() {
    //created a suspends function that takes in the email and password fields
    //returns the results as Wrapper Login Response
    suspend fun login(email: String, password: String): Wrapper<LoginResponse> {
        //set wrapper equal to the results of safeapicall
        //and takes in the response as a parameter
        val wrapper = safeApiCall { api.login(email, password) }
        //then return the wrapper convertToDomain function located in Network wrapper
        return wrapper.convertToDomain()

    }


}