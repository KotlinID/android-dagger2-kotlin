package com.baculsoft.sample.kotlindagger.injectors.component

import android.app.Application
import android.content.Context
import com.baculsoft.sample.kotlindagger.injectors.module.ApplicationModule
import com.baculsoft.sample.kotlindagger.injectors.scope.ApplicationContext
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    @ApplicationContext
    fun getContext(): Context

    fun inject(application: Application)
}