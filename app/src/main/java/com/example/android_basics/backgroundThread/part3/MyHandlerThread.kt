package com.example.android_basics.backgroundThread.part3

import android.os.Handler
import android.os.HandlerThread

class MyHandlerThread : HandlerThread("MyHandlerCustom"){

    private lateinit var handler: Handler

    override fun onLooperPrepared() {
        handler = Handler(looper)
    }

    fun getHandler(): Handler {
        return handler
    }
}