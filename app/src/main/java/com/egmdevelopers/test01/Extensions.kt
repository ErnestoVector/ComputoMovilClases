package com.egmdevelopers.test01

import android.content.Context
import android.widget.Toast

fun Context.toast(message: CharSequence) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).apply {
        show()
    }
}

fun Context.longToast(message: CharSequence) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).apply {
        show()
    }
}