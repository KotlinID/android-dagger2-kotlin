package com.baculsoft.sample.kotlindagger.injectors.module

import android.app.Application
import android.content.Context
import com.baculsoft.sample.kotlindagger.injectors.scope.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule constructor(private val application: Application) {

    @Provides
    internal fun provideApplication(): Application = application

    @Provides
    @ApplicationContext
    internal fun provideApplicationContext(): Context = application
}