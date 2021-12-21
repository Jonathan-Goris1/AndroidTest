package com.datechnologies.androidtest.data.repository

import com.datechnologies.androidtest.data.network.NetworkWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

// This abstract class will be used as a base for all repositories
// Meaning that any repository can implement these functions
abstract class BaseRepository {
    //A suspend function of type T
    suspend fun <T> safeApiCall(
            //This function will take in an apiCall this is a suspend
            // that will return a Response type T
            apiCall: suspend () -> Response<T>
            //The function will then be returned wrapped in NetworkWrapper of type T
    ): NetworkWrapper<T> {
        //We return withContext which Calls the specified suspending block
        // with a given coroutine context, suspends until it completes, and returns the result.
        return withContext(Dispatchers.IO) {
            //we put the results in a try catch that will handle how the
            //results will be return as
            try {
                //We try to invoke the api
                val networkRequest = apiCall.invoke()
                //We then attach the timeStamp to the response
                val timeStamp = getTimestamp(networkRequest)
                //Then we return the response as a Network Wrapper success
                NetworkWrapper.Success(networkRequest, timeStamp)
            } catch (throwable: Throwable) {
                //IF we get an error trying to invoke the api
                //We then try to figure what type of HttpException it is
                //Then we return it as one of our failures that the network wrapper handles
                when (throwable) {
                    is HttpException -> {
                        NetworkWrapper.Failure(false, throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        NetworkWrapper.Failure(true, null, null)
                    }
                }
            }
        }
    }

    //This function is used to get the timeStamp of the request
    private fun getTimestamp(response: Response<*>): Long {
        val timeSent = response.raw().sentRequestAtMillis
        val timeReceived = response.raw().receivedResponseAtMillis
        return timeReceived - timeSent
    }
}