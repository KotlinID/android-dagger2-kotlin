package com.baculsoft.sample.kotlindagger.injectors.component

import android.content.Context
import com.baculsoft.sample.kotlindagger.injectors.module.FragmentModule
import com.baculsoft.sample.kotlindagger.injectors.scope.ActivityContext
import com.baculsoft.sample.kotlindagger.injectors.scope.FragmentScope
import com.baculsoft.sample.kotlindagger.views.MainFragment
import dagger.Component

@FragmentScope
@Component(dependencies = arrayOf(ApplicationComponent::class),
           modules = arrayOf(FragmentModule::class)
)
interface FragmentComponent {

    @ActivityContext
    fun getContext(): Context

    fun inject(mainFragment: MainFragment)
}