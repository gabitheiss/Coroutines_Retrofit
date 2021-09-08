package com.example.coroutines_retrofit.retrofit

import com.example.coroutines_retrofit.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface Endpoint {

    @GET("/users")
    suspend fun buscarUsers() : Response<List<Users>>

}