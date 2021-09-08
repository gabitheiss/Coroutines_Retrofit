package com.example.coroutines_retrofit.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutines_retrofit.model.Users
import com.example.coroutines_retrofit.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: GithubRepository) : ViewModel() {


    val _userResponse = MutableLiveData<List<Users>>()
    val userResponse : LiveData<List<Users>> = _userResponse

    val _error = MutableLiveData<String>()
    var error : LiveData<String> = _error


    fun getUsers(){
        viewModelScope.launch {
            val responseUser = repository.buscarUsers()
            println(responseUser)
        }
    }

}