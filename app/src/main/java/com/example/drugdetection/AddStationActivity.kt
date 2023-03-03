package com.example.drugdetection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import com.example.drugdetection.R
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddStationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_station)

        val uniqueId = intent.getStringExtra("UNIQUE_ID")
        // using this uniqueId I'll fetch the document, add new station to it and then
        // put it back to the database.

        val submitBtn = findViewById<Button>(R.id.btn_submit)
        submitBtn.setOnClickListener {

            val etNameWidget = findViewById<EditText>(R.id.et_name)
            val etIdWidget = findViewById<EditText>(R.id.et_id)

            val stationName = etNameWidget.text.toString()
            val stationId = etIdWidget.text.toString()

            val db = Firebase.firestore
            if (uniqueId != null) {
                val docRef = db.collection("authMedicines").document(uniqueId)

                docRef.update("stations", FieldValue.arrayUnion(stationName))
                docRef.update("stationsId", FieldValue.arrayUnion(stationId))

            }

//            this doesn't work because, it expects an "Editable", and setText(setter) does the
//            needful and converts empty string to Editable.
//            etNameWidget.text = ""
            etNameWidget.setText("")
            etIdWidget.setText("")
        }
    }
}