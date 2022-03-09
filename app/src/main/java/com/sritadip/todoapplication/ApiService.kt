package com.sritadip.todoapplication

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("5a8e5b372f000048004f25fc")
    suspend fun getToDOList():List<Todo>

}