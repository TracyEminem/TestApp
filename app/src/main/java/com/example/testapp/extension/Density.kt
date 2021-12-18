package com.example.testapp.extension

import com.example.testapp.EyepetizerApplication

fun screenPixel():String{
    EyepetizerApplication.context.resources.displayMetrics.run {
        return "${widthPixels}*${heightPixels}"
    }
}