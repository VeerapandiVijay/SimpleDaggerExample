package com.optisol.dagger2example.config

import android.content.SharedPreferences
import com.hapmate.simpledaggerexample.application.AppController
import javax.inject.Inject

class SessionManager {
    @Inject
    internal lateinit var sharedPreferences: SharedPreferences

    init {
        AppController.appComponent.inject(this)
    }

    var token: String
        get() = sharedPreferences.getString("token", "")!!
        set(token) = sharedPreferences.edit().putString("token", token).apply()
}