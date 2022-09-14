package com.es.k_todo_firebase.utils

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun Fragment.toast(msg: String) {

    Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()

}