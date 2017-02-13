package com.baculsoft.sample.kotlindagger.injectors.component

import android.content.Context
import com.baculsoft.sample.kotlindagger.injectors.module.ActivityModule
import com.baculsoft.sample.kotlindagger.injectors.scope.ActivityContext
import com.baculsoft.sample.kotlindagger.injectors.scope.ActivityScope
import com.baculsoft.sample.kotlindagger.views.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class),
           modules = arrayOf(ActivityModule::class)
)
interface ActivityComponent {

    @ActivityContext
    fun getContext(): Context

    fun inject(mainActivity: MainActivity)
}