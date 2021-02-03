package com.example.metamask.repository

import com.mindorks.retrofit.coroutines.data.api.ApiService
import com.sprytech.vaccinepassport.repository.remote.IremoteRepository

class RemoteRepository(private val apiService: ApiService) : IremoteRepository {


    override suspend fun login(email: String, password : String) = apiService.getAccount(email,  password)
    override suspend fun signUp(name :String, email: String, mobile : String, password : String) = apiService.createAccount(name, email, mobile, password)
}