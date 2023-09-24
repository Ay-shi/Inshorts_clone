package com.androiddevs.mvvmnewsapp.api

import com.androiddevs.mvvmnewsapp.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        //companion object is an object that is initialised when corresponding class is loaded
        private val retrofit by lazy {
            //lazy is a way to initialise a property only when it is first accessed, useful for properties expensive to initialise
            val logging = HttpLoggingInterceptor()
            //An OkHttp interceptor which logs request and response information. Can be applied as an application interceptor or as a OkHttpClient.networkInterceptors.
            //The format of the logs created by this class should not be considered stable and may change slightly between releases. If you need a stable logging format, use your own interceptor.
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            //only body will be logged
            val client = OkHttpClient.Builder().addInterceptor(logging).build()
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val api by lazy{
            retrofit.create(NewsAPI::class.java)
        }
    }
}