package com.streaningworks.slackmimick

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "tokenbutton")
        val theme: Button = findViewById<View>(R.id.settoken) as Button
        theme.setOnClickListener{
           val intent = Intent(this, SaveTokenActivity::class.java)
            startActivity(intent)
        }

    }
}
