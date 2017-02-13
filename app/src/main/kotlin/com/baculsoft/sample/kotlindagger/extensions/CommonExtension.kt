package com.baculsoft.sample.kotlindagger.extensions

import android.support.design.widget.Snackbar
import android.view.View

internal fun makeSnackbar(view: View, message: String): Snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)