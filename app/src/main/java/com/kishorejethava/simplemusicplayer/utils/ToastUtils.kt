package com.kishorejethava.simplemusicplayer.utils

import android.content.Context
import android.widget.Toast
import com.kishorejethava.simplemusicplayer.App


object ToastUtils {
    fun shortToast(context: Context, stringCode: Int = 0, stringText: String? = null) {
        context.let {
            if (stringCode != 0) {
                Toast.makeText(it, it.getString(stringCode), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(it, stringText, Toast.LENGTH_SHORT).show()
            }
        }

    }
}