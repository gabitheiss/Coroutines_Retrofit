package com.example.coroutines_retrofit.model

import com.google.gson.annotations.SerializedName

data class Users(

    @SerializedName("login") val name: String,
    @SerializedName("avatar_url") val image: String,
    @SerializedName("id") val id: String
)
