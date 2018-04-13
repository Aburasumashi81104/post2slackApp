package com.streaningworks.slackmimick

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.EditText





class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    private var inputChannel: EditText? = null
    private var inputName: EditText? = null
    private var inputText: EditText? = null
    private var inputIcon: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //tokenボタン押下時の処理
        Log.d(TAG, "tokenbutton")
        val token: Button = findViewById<View>(R.id.settoken) as Button
        token.setOnClickListener{
           val intent = Intent(this, SaveTokenActivity::class.java)
            startActivity(intent)
        }

        inputChannel = findViewById(R.id.input_channel)
        inputName = findViewById(R.id.input_name)
        inputText = findViewById(R.id.input_text)
        inputIcon = findViewById(R.id.input_icon)

        //postボタン押下時の処理
        Log.d(TAG, "postbutton")
        val post: Button = findViewById<View>(R.id.posturl) as Button
        post.setOnClickListener{

            getChannelName()
            getCharName()
            getSendText()
            getIconUrl()

        }

    }

    private fun getChannelName(){
        inputChannel?.getText().toString()
    }
    private fun getCharName(){
        inputChannel?.getText().toString()
    }
    private fun getSendText(){
        inputText?.getText().toString()
    }
    private fun getIconUrl(){
        inputIcon?.getText().toString()
    }
}
