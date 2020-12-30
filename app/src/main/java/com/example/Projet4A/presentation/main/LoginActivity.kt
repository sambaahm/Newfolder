package com.example.Projet4A.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.Projet4A.R
import com.example.projet4A.presentation.main.LoginError
import com.example.projet4A.presentation.main.LoginSuccess
import com.example.projet4A.presentation.main.MainViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject


class LoginActivity : AppCompatActivity(){
    val mainViewModel: MainViewModel by this.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess ->{

                }
                LoginError -> MaterialAlertDialogBuilder(this)
                    .setTitle("ERROR")
                    .setMessage("compte inconnu")
                    .setPositiveButton("ok"){ dialog, which ->
                        dialog.dismiss()
                    }
                    .show()
            }
        })
        login_button.setOnClickListener {
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(),password_edit.text.toString())
        }

    }
}