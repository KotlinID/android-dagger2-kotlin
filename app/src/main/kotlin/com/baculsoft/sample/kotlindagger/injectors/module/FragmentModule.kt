package com.baculsoft.sample.kotlindagger.injectors.module

import android.content.Context
import android.support.v4.app.Fragment
import com.baculsoft.sample.kotlindagger.injectors.scope.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class FragmentModule constructor(private val fragment: Fragment) {

    @Provides
    internal fun provideFragment(): Fragment = fragment

    @Provides
    @ActivityContext
    internal fun provideFragmentContext(): Context = fragment.context
}