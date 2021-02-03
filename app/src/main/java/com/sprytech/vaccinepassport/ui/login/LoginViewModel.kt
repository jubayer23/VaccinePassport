package com.sprytech.vaccinepassport.ui.login

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.metamask.repository.RemoteRepository
import com.example.play2win.LocalAuthRepository
import com.mindorks.retrofit.coroutines.utils.Resource
import com.sprytech.vaccinepassport.model.UserProfile
import com.sprytech.vaccinepassport.repository.remote.IremoteRepository
import kotlinx.coroutines.Dispatchers

class LoginViewModel(private  val remoteRepository: IremoteRepository, private val localAuthRepository: LocalAuthRepository) : ViewModel() {

    var email = ObservableField("")
    var password = ObservableField("")

    val errorEmail = ObservableField<String>()
    val errorPassword = ObservableField<String>()

    fun login() = liveData(Dispatchers.IO) {
        if(!isFormValid()) return@liveData
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = remoteRepository.login(email.get().toString(),password.get().toString())))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun saveProfile(userProfile : UserProfile){
        localAuthRepository.setCurrentUser(userProfile)
    }

    fun isFormValid(): Boolean {

        Log.d("DEBUG", "its here")
        if(email.get().toString().isEmpty()){
            errorEmail.set("Cannot be empty!")
            return false
        }else {
            errorEmail.set(null);
        }
        if(password.get().toString().isEmpty()){
            password.set("Cannot be empty!")
            return false
        }else{
            password.set(null)
        }
        return true
    }

}