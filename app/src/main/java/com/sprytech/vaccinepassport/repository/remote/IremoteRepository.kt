package com.sprytech.vaccinepassport.repository.remote

import com.sprytech.vaccinepassport.model.UserProfile

interface IremoteRepository {

    suspend fun login(email : String, password : String) : UserProfile
    suspend fun signUp(name : String, email : String, mobile : String, password : String) : UserProfile
}