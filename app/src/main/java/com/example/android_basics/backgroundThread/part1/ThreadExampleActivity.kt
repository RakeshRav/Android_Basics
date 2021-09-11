package com.example.android_basics.backgroundThread.part1

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.android_basics.R

class ThreadExampleActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "ThreadExampleActivity"
    }

    var mainHandler = Handler()
    @Volatile var stopThread = false

    var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_example)

        button = findViewById(R.id.start)
    }

    fun start(view: View) {
//        val thread = MyThread(10)
//        thread.start()

        val runnable = MyRunnable(10)
        Thread(runnable).start()

//        //annonymous way
//         Thread{
//             //your work here
//         }.start()
    }

    fun stop(view: View) {
        stopThread = true
    }

    class MyThread(val seconds: Int) : Thread() {
        override fun run() {
            for (i in 0 until seconds) {
                try {
                    Log.d(TAG, "start: $i")
                    Thread.sleep(1000)
                } catch (e: Exception) {

                }
            }
        }
    }

    inner class MyRunnable(val seconds: Int) : Runnable {
        override fun run() {
            for (i in 0 until seconds) {
                if(i == 5) {
//                    val handler = Handler(Looper.getMainLooper())
//                    handler.post {
//                        button?.text = "50%"
//                    }
//                    button?.post{
//                        button?.text = "50%"
//                    }
                    runOnUiThread{
                        button?.text = "50%"
                    }
                }
                if(stopThread) return
                try {
                    Log.d(TAG, "start: $i")
                    Thread.sleep(1000)
                } catch (e: Exception) {

                }
            }
        }
    }
}