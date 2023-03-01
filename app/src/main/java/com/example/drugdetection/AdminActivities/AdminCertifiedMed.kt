package com.example.drugdetection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class AdminCertifiedMed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_certified_med)

        val intent = intent
        val uniqueId = intent.getStringExtra("UNIQUE_ID")

//        Toast.makeText(this, "UNIQUE_ID = $uniqueId", Toast.LENGTH_LONG).show()

    }
}