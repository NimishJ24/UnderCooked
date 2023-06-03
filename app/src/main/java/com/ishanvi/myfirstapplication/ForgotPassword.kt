package com.ishanvi.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ForgotPassword : AppCompatActivity() {
    lateinit var etMobileNum: EditText
    lateinit var etEmail: EditText
    lateinit var btNext:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        etMobileNum= findViewById(R.id.etMoblieNum)
        etEmail=findViewById(R.id.etEmail)
        btNext=findViewById(R.id.btNext)




        btNext.setOnClickListener {
            val mobilenum=etMobileNum.text.toString()
            val email=etEmail.text.toString()
            var list= arrayListOf<String>(mobilenum,email)
            if (list.contains("")){
                Toast.makeText(this@ForgotPassword,"Incorrect Credentials",Toast.LENGTH_LONG).show()
            }
            else{
                val intent= Intent(this@ForgotPassword,WelcomePage::class.java)
                intent.putExtra("Info",list)
                startActivity(intent)
                finish()
            }
        }


    }
}


