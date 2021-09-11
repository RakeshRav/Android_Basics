package com.example.android_basics.backgroundThread.part3

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.SystemClock
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.android_basics.R

class HandlerThreadActivity : AppCompatActivity() {

    private val handlerThread = MyHandlerThread()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_thread)
        handlerThread.start()
    }

    fun removeMsg(view: View) {
        handlerThread.getHandler().removeCallbacksAndMessages(null)
    }

    fun doWork(view: View) {
        handlerThread.getHandler().post(MyRunnable1())
        handlerThread.getHandler().postDelayed(MyRunnable2(), 2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handlerThread.quit()
    }

    companion object { 
        private const val TAG = "HandlerThreadActivity"
    }

    class MyRunnable1 : Runnable {
        override fun run() {
            for (i in 0 until 5) {
                Log.d(TAG, "run first: $i")
                SystemClock.sleep(1000)
            }
        }

    }

    class MyRunnable2 : Runnable {
        override fun run() {
            for (i in 0 until 5) {
                Log.d(TAG, "run second: $i")
                SystemClock.sleep(1000)
            }
        }

    }
}