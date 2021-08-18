package com.hapmate.simpledaggerexample.utils

import com.hapmate.simpledaggerexample.config.Constants
import com.optisol.dagger2example.config.SessionManager

import javax.inject.Inject

class CommonMethods {

    @Inject
    internal lateinit var sessionManager: SessionManager

    public fun getAppName(): String{
        return Constants.APP_NAME;
    }
}
