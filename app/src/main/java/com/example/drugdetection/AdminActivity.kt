package com.example.drugdetection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)


        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val adminId = findViewById<EditText>(R.id.adminId)
            val adminPass = findViewById<EditText>(R.id.adminPass)

            Toast.makeText(this,"this is adminId : ${adminId.text}," +
                    " and this is adminPass : ${adminPass.text}", Toast.LENGTH_LONG).show()
        }
    }
}