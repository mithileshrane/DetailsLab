package com.samrans.labtest.apicalling

import com.samrans.labtest.utils.NetworkConnectionInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiClient {

    companion object{
        operator fun invoke(networkConnectionInterceptor:NetworkConnectionInterceptor):ApiClient{

            val incept= HttpLoggingInterceptor()
            incept.setLevel(HttpLoggingInterceptor.Level.HEADERS)
            incept.setLevel(HttpLoggingInterceptor.Level.BODY)

//            val client=OkHttpClient()
//            client.interceptors().add(incept)

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .addInterceptor(incept)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}