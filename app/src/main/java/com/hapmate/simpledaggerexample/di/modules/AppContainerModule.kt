package com.hapmate.simpledaggerexample.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.hapmate.simpledaggerexample.config.Constants
import com.optisol.dagger2example.config.SessionManager
import com.hapmate.simpledaggerexample.utils.CommonMethods
import dagger.Module
import dagger.Provides
import java.util.HashMap
import javax.inject.Singleton

@Module(includes = [ApplicationModule::class])
class AppContainerModule {
    @Provides
    @Singleton
    internal fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences(Constants.APP_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    internal fun provideSessionManager(): SessionManager {
        return SessionManager()
    }

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    internal fun provideStringHashMap(): HashMap<String, String> {
        return HashMap()
    }

    @Provides
    @Singleton
    internal fun provideCommonMethods(): CommonMethods {
        return CommonMethods()
    }
}