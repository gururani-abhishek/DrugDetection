package com.example.drugdetection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.drugdetection.R

class AddStationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_station)

        val uniqueId = intent.getStringExtra("UNIQUE_ID")

    }
}