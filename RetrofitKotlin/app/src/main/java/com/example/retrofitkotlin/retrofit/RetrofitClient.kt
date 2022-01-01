package com.example.retrofitkotlin.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    var BASE_URL : String = "https://jsonplaceholder.typicode.com/"
    val retrofitApiInterface : RetrofitApiInterface
//    get(){
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        return retrofit.create(RetrofitApiInterface::class.java)
//    }

    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitApiInterface =  retrofit.create(RetrofitApiInterface::class.java)
    }



}