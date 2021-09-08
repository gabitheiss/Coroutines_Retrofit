package com.example.coroutines_retrofit.repository

import com.example.coroutines_retrofit.model.Users
import com.example.coroutines_retrofit.retrofit.Endpoint
import kotlinx.coroutines.*
import retrofit2.Response
import javax.inject.Inject

class GithubRepository @Inject constructor(private val services: Endpoint) {


    suspend fun buscarUsers() : List<Users>?{
        return CoroutineScope(Dispatchers.Default).async {
            val response = services.buscarUsers()
            processData(response)
        }.await()
    }

    //criar funcao generica pois ainda nao sabemos o que esta vindo do retrofit, se é
    //lista, se é user, se é repositorios etc
    private fun <T> processData(response : Response<T>) : T? {
      return if (response.isSuccessful) response.body()
             else null
    }


//    exemplo simplificado, faz a mesma coisa que o exemplo acima
//    suspend fun getUsers(): List<Users>? {
//        return withContext(CoroutineScope(Dispatchers.Default).coroutineContext) {
//            val response =
//                services.buscarUsers()
//            processData(response)
//        }
//    }

}