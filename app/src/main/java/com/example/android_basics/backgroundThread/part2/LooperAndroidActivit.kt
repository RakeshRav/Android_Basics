package com.example.android_basics.backgroundThread.part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.os.SystemClock
import android.util.Log
import android.view.View
import com.example.android_basics.R

class LooperAndroidActivit : AppCompatActivity() {

    private val looperThread = LooperThread()
    companion object{
        private const val TAG = "LooperAndroidActivit"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_looper_android)
    }

    fun start(view: View){
        looperThread.start()
    }

    fun stop(view: View){
        looperThread.looper?.quitSafely()
    }

    fun taskA(view: View){
        val message = Message.obtain()
        message.what = 1

        looperThread.handler.sendMessage(message)
//        looperThread.handler.post{
//            for (i in 0 until 5){
//                Log.d(TAG, "run: $i")
//                SystemClock.sleep(1000)
//            }
//        }
    }

    fun taskB(view: View){
        val message = Message.obtain()
        message.what = 2

        looperThread.handler.sendMessage(message)
    }

    class MyInnerClass: Runnable{

        override fun run() {
        }
    }
}