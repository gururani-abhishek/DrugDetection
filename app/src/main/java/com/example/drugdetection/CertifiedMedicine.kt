package com.example.drugdetection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class CertifiedMedicine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certified_medicine)

        val uniqueId = intent.getStringExtra("UNIQUE_ID")

//        Toast.makeText(this, "UNIQUE_ID = $uniqueId", Toast.LENGTH_LONG).show()

        val btn = findViewById<Button>(R.id.details)
        btn.setOnClickListener {
            val intent = Intent(this, PreviousStationsPresentationActivity::class.java)
            intent.putExtra("UNIQUE_ID", uniqueId)
            startActivity(intent)
        }
    }
}