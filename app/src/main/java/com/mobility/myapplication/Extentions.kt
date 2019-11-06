package com.mobility.myapplication

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

/**
 *
 * Created By JISHAN ANSARI On 11/6/2019
 */

fun Context.showMessage(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun ProgressBar.handleProgress(visibility : Int = View.VISIBLE) {
    this.visibility = visibility
}