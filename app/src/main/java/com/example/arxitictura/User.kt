package com.example.arxitictura

import android.text.TextUtils
import android.util.Patterns

data class User(private var email: String, private val password: String) : IUser {

    override fun getEmail(): String {
        return email
    }

    override fun getPassword(): String {
        return password
    }

    override fun getValid(): Int {
        when {
            TextUtils.isEmpty(getEmail()) -> {
                return 0
            }
            Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() -> {
                return 1
            }
            TextUtils.isEmpty(getPassword()) -> {
                return 2
            }
            getPassword().length < 6 -> {
                return 3
            }
            else -> return -1
        }
    }

}