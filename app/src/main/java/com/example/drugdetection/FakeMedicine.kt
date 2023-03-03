package com.example.drugdetection

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FakeMedicine : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fake_medicine)

        // extracting uniqueId from intent which redirected me to this activiy.
        val uniqueId = intent.getStringExtra("UNIQUE_ID")

        val btnReportSubmit = findViewById<Button>(R.id.btn_report_submit)
        btnReportSubmit.setOnClickListener {
            val reportId = uniqueId + "_report" // made a custom reportId


            // get an instance of your firestore db
            val db = Firebase.firestore

            // extracting report from editview
            val etReportWidget = findViewById<EditText>(R.id.et_report)

            // my app was crashing because I was not providing reportData in the
            // expected format, firestore expects data in a specific format
            val reportData = hashMapOf(
                "reportDes" to etReportWidget.text.toString()
            )

//             putting this report  in the database using set()
            db.collection("reports").document(reportId)
                .set(reportData)

            etReportWidget.setText("")
        }

    }
}