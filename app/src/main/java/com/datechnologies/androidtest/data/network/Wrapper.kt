package com.datechnologies.androidtest.data.network

import okhttp3.ResponseBody

sealed class Wrapper<out T> {
    data class Success<out T>(val value: T, val networkCallDuration: Long) : Wrapper<T>()
    data class Failure(
            val isNetworkError: Boolean,
            val errorCode: Int?,
            val errorBody: ResponseBody?
    ) : Wrapper<Nothing>()

    object Loading : Wrapper<Nothing>()
}