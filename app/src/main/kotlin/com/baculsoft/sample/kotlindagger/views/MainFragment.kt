package com.baculsoft.sample.kotlindagger.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.baculsoft.sample.kotlindagger.App
import com.baculsoft.sample.kotlindagger.R
import com.baculsoft.sample.kotlindagger.extensions.makeSnackbar
import com.baculsoft.sample.kotlindagger.injectors.component.DaggerFragmentComponent
import com.baculsoft.sample.kotlindagger.injectors.component.FragmentComponent
import com.baculsoft.sample.kotlindagger.injectors.module.FragmentModule
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment @Inject constructor() : Fragment() {
    lateinit var component: FragmentComponent

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initInjector()
        initComponent()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main, container, false);
    }

    private fun initInjector() {
        component = DaggerFragmentComponent.builder()
                                           .applicationComponent(App.component)
                                           .fragmentModule(FragmentModule(this))
                                           .build()
        component.inject(this)
    }

    private fun initComponent() {
        btn_main_click.setOnClickListener { view ->
            val message: String = et_main_message.text.toString()

            if (!TextUtils.isEmpty(message)) {
                makeSnackbar(rl_main, message).show()
            }
        }
    }
}