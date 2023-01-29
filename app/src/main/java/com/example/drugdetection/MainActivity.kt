package com.example.drugdetection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    private val viewModel : SplashScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customerBtn: Button = findViewById(R.id.customerBtn)
        customerBtn.setOnClickListener {
            startActivity(Intent(this, CustomerActivity::class.java))
        }

        val adminBtn : Button = findViewById(R.id.adminBtn)
        adminBtn.setOnClickListener {
            startActivity(Intent(this, AdminActivity::class.java))
        }

    }
}