package com.example.arxitictura

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

lateinit var login: Button
lateinit var editTextEmail: EditText
lateinit var editTextPassword: EditText


class MainActivity : AppCompatActivity(), ILoginView {
    var curentIndex: Int = 0
    lateinit var loginController: ILoginController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginController = LoginController(this)

        editTextEmail = findViewById(R.id.email)
        editTextPassword = findViewById(R.id.paassword)
        login = findViewById(R.id.loginBtn)

        login.setOnClickListener {
            loginController.onLogin(editTextEmail.text.toString().trim(), editTextPassword.text.toString()
                .trim())

        }

    }

    override fun onLoginSuccess(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}