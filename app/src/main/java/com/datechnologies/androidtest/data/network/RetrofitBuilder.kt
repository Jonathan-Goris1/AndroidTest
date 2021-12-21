package com.datechnologies.androidtest.data.network


import com.datechnologies.androidtest.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    companion object {
        //This is the Base Url that both request will use
        private const val BASE_URL = "http://dev.rapptrlabs.com/Tests/scripts/"
    }

    // This function takes in an api as a parameter
    // to distinguish which api call we are going to make.
    //The function then builds the retrofit builder for the api
    //added an logging Interceptor for debugging purposes
    fun <Api> buildApi(
            api: Class<Api>
    ): Api {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient.Builder().also { client ->
                    if (BuildConfig.DEBUG) {
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(logging)
                    }
                }.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(api)
    }
}