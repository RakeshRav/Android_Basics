package com.example.android_basics.backgroundThread.part2

import android.os.Handler
import android.os.Looper
import android.util.Log

class LooperThread : Thread() {

    companion object{
        private const val TAG = "LooperThread"
    }

    lateinit var handler: Handler
    var looper: Looper? = null

    override fun run() {
//1
        Looper.prepare()
   //2
        looper = Looper.myLooper()
      //3
        handler = MyHandler()
//4
        Looper.loop() //loop infinite

        Log.d(TAG, "end of run")
    }
}