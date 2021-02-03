package com.mindorks.retrofit.coroutines.data.api



import com.sprytech.vaccinepassport.model.UserProfile
import retrofit2.http.*
import java.security.PrivateKey

interface ApiService {


    @POST("hts-api/getAccount")
    suspend fun getAccount(@Query("email") email: String, @Query("password") password: String): UserProfile


    @POST("hts-api/create-account")
    suspend fun createAccount(@Query("name") username: String, @Query("email") email: String, @Query("mobile") mobile: String, @Query("password") password: String): UserProfile


}