package com.example.android_basics

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.android_basics.jetpack_compose.JetpackListActivity
import com.example.android_basics.jetpack_compose.RecyclerViewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openJetpackActivity(view: View) {
        startActivity(Intent(this, JetpackListActivity::class.java))
    }

    fun openRecyclerViewActivity(view: View) {
        startActivity(Intent(this, RecyclerViewActivity::class.java))
    }
}