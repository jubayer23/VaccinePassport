package com.sprytech.vaccinepassport.model

import java.security.PrivateKey
import java.security.PublicKey

data class HederaAccount(val id : String, val publicKey: PublicKey, val privateKey: PrivateKey)