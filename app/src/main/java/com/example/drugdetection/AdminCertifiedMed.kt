package com.example.drugdetection

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AdminCertifiedMed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_certified_med)

        val uniqueId = intent.getStringExtra("UNIQUE_ID")

        val showStationsBtn = findViewById<Button>(R.id.details)
        showStationsBtn.setOnClickListener {
            val intent = Intent(this, PreviousStationsPresentationActivity::class.java)
            intent.putExtra("UNIQUE_ID", uniqueId)
            startActivity(intent)
        }

        val addCurrentStationBtn = findViewById<Button>(R.id.addStations)
        addCurrentStationBtn.setOnClickListener {
            startActivity(Intent(this, AddStationActivity::class.java).putExtra("UNIQUE_ID", uniqueId))
        }
    }
}