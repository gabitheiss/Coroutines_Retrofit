package com.example.coroutines_retrofit.di

import com.example.coroutines_retrofit.retrofit.Endpoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun endpointInterface(endpoint: Endpoint): Endpoint = Endpoint(endpoint)

}