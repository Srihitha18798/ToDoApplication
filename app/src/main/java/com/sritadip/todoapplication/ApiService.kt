package com.sritadip.todoapplication

import retrofit2.http.GET

interface ApiService {

    @GET("5a8e5b372f000048004f25fc")
    suspend fun getToDOList():List<Todo>

}