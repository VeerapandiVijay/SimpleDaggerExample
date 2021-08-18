package com.hapmate.simpledaggerexample.application

import android.app.Application
import com.hapmate.simpledaggerexample.config.Constants
import com.hapmate.simpledaggerexample.di.components.AppComponent
import com.hapmate.simpledaggerexample.di.components.DaggerAppComponent
import com.hapmate.simpledaggerexample.di.modules.ApplicationModule
import com.hapmate.simpledaggerexample.di.modules.NetworkModule

class AppController: Application() {
    override fun onCreate() {
        super.onCreate()

        // Dagger%COMPONENT_NAME%
        appComponent = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this)) // This also corresponds to the name of your module: %component_name%Module
            .networkModule(NetworkModule(Constants.BASE_URL))
            .build()

        appComponent.inject(this)

    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}