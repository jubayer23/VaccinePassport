package com.example.play2win

import androidx.lifecycle.LiveData
import com.sprytech.vaccinepassport.model.UserProfile

interface ILocalAuthRepository {

    fun hasEverLogin(): Boolean

    fun getCurrentUser(): UserProfile?

    fun setCurrentUser(userProfile: UserProfile)

    fun clearCurrentUser()

    fun observeAuthState(): LiveData<Boolean>
}