package com.ishanvi.myfirstapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomePage : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_welcome_page)
        var displayinfo:String=""
        val info=intent.getStringArrayListExtra("Info")
        if (info != null) {
            for(ele in 0 until info.size){
                displayinfo=displayinfo+info[ele]+"\n"

            }
        }
            val textviewn=findViewById<TextView>(R.id.txtName).apply {
                text=displayinfo

            }





        }


            }

