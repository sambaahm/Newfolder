package com.example.Projet4A.presentation.main

import com.example.projet4A.presentation.main.LoginError
import com.example.projet4A.presentation.main.LoginStatus

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.projet4A.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.projet4A.presentation.main.LoginSuccess as LoginSuccess1

class LoginViewModel(
    private val getUserUseCase: GetUserUseCase
) : ViewModel(){

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(email: String, password: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(email)
            val loginStatus = if (user != null){
                LoginSuccess1(user.email)
            }else  {
                LoginError
            }

            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }
        }
    }
}
