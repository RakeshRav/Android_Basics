package com.example.android_basics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_basics.architecture_components.ui.NotesActivity
import com.example.android_basics.backgroundThread.part1.ThreadExampleActivity
import com.example.android_basics.backgroundThread.part2.LooperAndroidActivit
import com.example.android_basics.backgroundThread.part3.HandlerThreadActivity
import com.example.android_basics.navigation_components.ui.NavGraphActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, NavGraphActivity::class.java))
    }
}