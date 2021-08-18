package com.hapmate.simpledaggerexample.di.components

import com.hapmate.simpledaggerexample.MainActivity
import com.hapmate.simpledaggerexample.application.AppController
import com.optisol.dagger2example.config.SessionManager
import com.hapmate.simpledaggerexample.di.modules.AppContainerModule
import com.hapmate.simpledaggerexample.di.modules.ApplicationModule
import com.hapmate.simpledaggerexample.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ApplicationModule::class, AppContainerModule::class])
interface AppComponent {

    fun inject(sessionManager: SessionManager?)

    fun inject(appController: AppController?)

    fun inject(mainActivity: MainActivity)
}