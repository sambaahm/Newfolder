package com.example.projet4A.presentation.main

sealed class LoginStatus
data class LoginSuccess(val email: String) : LoginStatus()
object LoginError : LoginStatus()