package com.ishanvi.myfirstapplication

import android.content.Context
import android.content.Intent
import android.app.Activity
import android.app.AlertDialog
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.ishanvi.myfirstapplication.util.ConnectionManager
import org.json.JSONException


class MainActivity : AppCompatActivity(){

    lateinit var txtForgotP: TextView
    lateinit var txtNoAccount: TextView
    lateinit var btLogin: Button
    lateinit var etPassword: EditText
    lateinit var etMobileNum:EditText
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name ), MODE_PRIVATE)
        val intent=Intent(this@MainActivity,Welcome2::class.java)
        val loggedIn=sharedPreferences.getBoolean("loggedIn",false)
        if(loggedIn){

            startActivity(intent)
            finish()


        }
        val queue = Volley.newRequestQueue(this@MainActivity as Context)
        val url = "http://13.235.250.119/v2/restaurants/fetch_result/"

        txtForgotP=findViewById(R.id.txtForgotP)
        txtNoAccount=findViewById(R.id.txtNoAccount)
        etPassword=findViewById(R.id.etPassword)
        etMobileNum=findViewById(R.id.etMoblieNum)
        btLogin=findViewById(R.id.btLogin)

            btLogin.setOnClickListener {
                val mobilenum = etMobileNum.text.toString()
                val password = etPassword.text.toString()
                var list = listOfNotNull(mobilenum, password)
                if (list.contains("")) {
                    Toast.makeText(this@MainActivity, "Invalid Credentials", Toast.LENGTH_LONG)
                        .show()

                } else {


                    sharedPreferences.edit().putBoolean("loggedIn", true).apply()
                    sharedPreferences.edit().putString("MobileNum", mobilenum).apply()
                    startActivity(intent)
                    finish()
                }
            }

            txtForgotP.setOnClickListener {
                val intentForgotP = Intent(this@MainActivity, ForgotPassword::class.java)
                startActivity(intentForgotP)
                finish()
            }
            txtNoAccount.setOnClickListener {
                val intentNoAcc = Intent(this@MainActivity, RegisterYourself::class.java)
                startActivity(intentNoAcc)
                finish()
            }






    }



}