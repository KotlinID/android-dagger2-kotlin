package com.baculsoft.sample.kotlindagger.injectors.module

import android.app.Activity
import android.content.Context
import com.baculsoft.sample.kotlindagger.injectors.scope.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule constructor(private val activity: Activity) {

    @Provides
    internal fun provideActivity(): Activity = activity

    @Provides
    @ActivityContext
    internal fun provideActivityContext(): Context = activity
}