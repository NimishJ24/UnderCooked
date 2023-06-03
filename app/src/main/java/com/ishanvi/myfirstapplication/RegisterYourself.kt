package com.ishanvi.myfirstapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterYourself : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etMobileNum: EditText
    lateinit var etDeliveryAddress: EditText
    lateinit var etChoosePassw: EditText
    lateinit var etConfirmPassw: EditText
    lateinit var btRegister: Button
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name ), MODE_PRIVATE)
        setContentView(R.layout.activity_register_yourself)

        etName=findViewById(R.id.etName)
        etEmail=findViewById(R.id.etEmail)
        etMobileNum=findViewById(R.id.etMoblieNum)
        etDeliveryAddress=findViewById(R.id.etDeliveryAddress)
        etChoosePassw=findViewById(R.id.etChoosePassw)
        etConfirmPassw=findViewById(R.id.etConfirmPassw)
        btRegister=findViewById(R.id.btRegister)


        btRegister.setOnClickListener {
            val choosepassw=etChoosePassw.text.toString()
            val confirmpassw=etConfirmPassw.text.toString()
            val name=etName.text.toString()
            val deliveryaddress=etDeliveryAddress.text.toString()
            val mobilenum=etMobileNum.text.toString()
            val email=etEmail.text.toString()
            val list= arrayListOf<String>(choosepassw,confirmpassw,name,deliveryaddress,mobilenum,email)

            if (list.contains("")) {
                Toast.makeText(this@RegisterYourself, "Invalid credentials", Toast.LENGTH_LONG)
                    .show()
            }
            else if(choosepassw!=confirmpassw) {
                Toast.makeText(this@RegisterYourself, "Incorrect Password", Toast.LENGTH_LONG)
                    .show()
            }
            else{

                    val intent= Intent(this@RegisterYourself,WelcomePage::class.java)
                    intent.putExtra("Info",list)
                sharedPreferences.edit().putBoolean("loggedIn", true).apply()
                sharedPreferences.edit().putString("MobileNum", mobilenum).apply()
                    startActivity(intent)
                    finish()
                }


        }

    }
}