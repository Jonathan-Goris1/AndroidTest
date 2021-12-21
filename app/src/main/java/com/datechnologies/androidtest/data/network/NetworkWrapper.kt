package com.datechnologies.androidtest.data.network

import okhttp3.ResponseBody
import retrofit2.Response

sealed class NetworkWrapper<out T> {
    data class Success<T>(val value: Response<T>, val networkCallDuration: Long) : NetworkWrapper<T>()
    data class Failure(
            val isNetworkError: Boolean,
            val errorCode: Int?,
            val errorBody: ResponseBody?
    ) : NetworkWrapper<Nothing>()

    private fun isSuccessful(): Boolean {
        return this is Success && this.value.isSuccessful
    }

    fun convertToDomain(): Wrapper<T> {
        if (this is Failure) {
            return Wrapper.Failure(true, this.errorCode, this.errorBody)
        }

        val s = this as Success
        if (this.isSuccessful()) {
            return Wrapper.Success(s.value.body()!!, s.networkCallDuration)
        }
        return Wrapper.Failure(false, s.value.code(), s.value.errorBody())
    }
}

