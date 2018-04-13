package com.streaningworks.slackmimick

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_save_token.*
import android.R.id.edit
import android.content.Context
import android.widget.TextView
import com.streaningworks.slackmimick.R.id.text
import java.io.FileNotFoundException
import java.io.IOException


class SaveTokenActivity : AppCompatActivity() {

    private val fileName : String = "testfile.txt"
//   private var dataStore: SharedPreferences? = null
//   private var inputToken: EditText? = null
//   private val textWrite: TextView? = null
    val textRead: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_token)

        savebutton.setOnClickListener({
                val text : String = input_token.getText().toString()
                saveFile(fileName,text)
                if(text.isEmpty()){
                    text_view.setText(R.string.no_text)
                } else {
                    text_view.setText(R.string.saved)
                }

        })

        readbutton.setOnClickListener({

            var str : String = readFile(fileName)
            if(str.isEmpty()) text_view.setText(R.string.read_error)
            else text_view.setText(str)

        })

    }

    //"testfile.txt"にtokenを保存
    fun saveFile(file : String,str : String){
        try {
            val out = openFileOutput(file,Context.MODE_PRIVATE)
            out.write(str.toByteArray())
            out.close()
        } catch (e: IOException){
            e.printStackTrace()

        }
    }

    //"testfile.txt"に保存されたtokenを表示
    fun readFile(file : String) : String {
        var text : String = ""
        try{
            val reader = openFileInput(file).bufferedReader()
            for(lineBuffer in reader.readLines()){
                text += lineBuffer.toString()
            }
            reader.close()
        } catch(e: FileNotFoundException){
            e.printStackTrace()
        }
        return text
    }

}
