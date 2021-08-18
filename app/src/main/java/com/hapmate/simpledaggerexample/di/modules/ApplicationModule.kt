package com.hapmate.simpledaggerexample.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    internal fun provideApplication(): Application {
        return application
    }
}