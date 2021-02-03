package com.sprytech.vaccinepassport.model

data class UserProfile(
        val status : Boolean,
        val userId : Int,
        val name : String,
        val email : String,
        val mobile : String,
        val hederaAccount: HederaAccount
)