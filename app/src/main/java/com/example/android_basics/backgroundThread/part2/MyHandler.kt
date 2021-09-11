package com.example.android_basics.backgroundThread.part2

import android.os.Handler
import android.os.Message
import android.util.Log

class MyHandler : Handler() {

    companion object{
        private const val TAG = "MyHandler"
    }
    val TASK_A = 1
    val TASK_B = 2
    override fun handleMessage(msg: Message) {
        when(msg.what){
            TASK_A -> Log.d(TAG, "handleMessage: task A Handled")
            TASK_B -> Log.d(TAG, "handleMessage: task B Handled")
        }
    }
}