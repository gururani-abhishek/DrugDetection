package com.example.drugdetection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AdminActivity : AppCompatActivity() {


    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)


        // getting shared instance of firebase auth object :
        auth = Firebase.auth

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val adminId = findViewById<EditText>(R.id.adminId)
            val adminPass = findViewById<EditText>(R.id.adminPass)
            val pb = findViewById<ProgressBar>(R.id.progressBar)

//            Toast.makeText(this,"this is adminId : ${adminId.text}," +
//                    " and this is adminPass : ${adminPass.text}", Toast.LENGTH_LONG).show()

            val id = adminId.text.toString()
            val pass = adminPass.text.toString()
            // checking if adminId and passcode field is empty
            if(id.isEmpty() or pass.isEmpty()) {
                Toast.makeText(this, "Please enter your ID and Passcode", Toast.LENGTH_SHORT).show()
            } else {
                pb.visibility = View.VISIBLE
            auth.signInWithEmailAndPassword(id, pass)
                .addOnCompleteListener(this) { task ->
                    if(task.isSuccessful) {
                        startActivity(Intent(this, AdminMedCheck::class.java))
//                        Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
                        pb.visibility = View.INVISIBLE
                    } else {
                        pb.visibility = View.INVISIBLE
                        Toast.makeText(this, "Failure, wrong credentials", Toast.LENGTH_SHORT).show()
                        adminId.setText("")
                        adminPass.setText("")
                    }
                }
            }

        }
    }
}