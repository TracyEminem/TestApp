package com.example.testapp

import android.app.Application
import android.content.Context

class EyepetizerApplication :Application(){

    companion object{
        lateinit var context:Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}