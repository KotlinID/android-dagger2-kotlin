package com.baculsoft.sample.kotlindagger

import android.app.Application
import com.baculsoft.sample.kotlindagger.injectors.component.ApplicationComponent
import com.baculsoft.sample.kotlindagger.injectors.component.DaggerApplicationComponent
import com.baculsoft.sample.kotlindagger.injectors.module.ApplicationModule

class App : Application() {

    companion object {
        lateinit var component: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }
}