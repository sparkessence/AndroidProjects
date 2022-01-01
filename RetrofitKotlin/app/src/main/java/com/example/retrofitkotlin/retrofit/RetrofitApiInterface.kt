package com.example.retrofitkotlin.retrofit

import com.example.retrofitkotlin.model.AlbumDataModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApiInterface {

    @GET("photos")
    fun getPhotos() : Call<List<AlbumDataModel>>
}