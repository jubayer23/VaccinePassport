package com.mindorks.retrofit.coroutines.ui.base

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.metamask.repository.RemoteRepository
import com.example.play2win.LocalAuthRepository
import com.mindorks.retrofit.coroutines.data.api.ApiService
import com.sprytech.vaccinepassport.ui.login.LoginViewModel

class ViewModelFactory(private val apiService: ApiService, private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(RemoteRepository(apiService),LocalAuthRepository(context)) as T
        }
        /*if (modelClass.isAssignableFrom(LoadAccountViewModel::class.java)) {
            return LoadAccountViewModel(MainRepository(apiHelper),LocalAuthRepository(context)) as T
        }
        if (modelClass.isAssignableFrom(CreateAccountViewModel::class.java)) {
            return CreateAccountViewModel(MainRepository(apiHelper),LocalAuthRepository(context)) as T
        }
        if (modelClass.isAssignableFrom(TestHtsViewModel::class.java)) {
            return TestHtsViewModel(MainRepository(apiHelper),LocalAuthRepository(context)) as T
        }*/
        throw IllegalArgumentException("Unknown class name")
    }

}

