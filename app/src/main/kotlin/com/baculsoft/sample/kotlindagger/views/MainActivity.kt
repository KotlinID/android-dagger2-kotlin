package com.baculsoft.sample.kotlindagger.views

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.baculsoft.sample.kotlindagger.App
import com.baculsoft.sample.kotlindagger.R
import com.baculsoft.sample.kotlindagger.injectors.component.ActivityComponent
import com.baculsoft.sample.kotlindagger.injectors.component.DaggerActivityComponent
import com.baculsoft.sample.kotlindagger.injectors.module.ActivityModule
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragment: MainFragment

    lateinit var component: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initInjector()
        initToolbar()
        showMessage()
        addButtonListener()
    }

    private fun initInjector() {
        component = DaggerActivityComponent.builder()
                                           .applicationComponent(App.component)
                                           .activityModule(ActivityModule(this))
                                           .build()
        component.inject(this)
    }

    private fun initToolbar() {
        toolbar_main.title = title
        setSupportActionBar(toolbar_main)
    }

    private fun showMessage() {
        toast("Welcome!")
    }

    private fun addButtonListener() {
        btn_main.setOnClickListener { view ->
            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fl_main, fragment, MainFragment::class.java.simpleName)
            fragmentTransaction.commit()
        }
    }
}