package com.example.drugdetection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AdminMedCheck : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_med_check)

        // when the ok button is clicked, that unique ID is checked in the db.
        val okBtn = findViewById<Button>(R.id.okBtn)
        okBtn.setOnClickListener {
            val uniqueIdWidget = findViewById<EditText>(R.id.uniqueId)
            val uniqueId = uniqueIdWidget.text.toString()

            if (uniqueId.isEmpty()) {
                uniqueIdWidget.setText("")
                Toast.makeText(this, "please input unique Id", Toast.LENGTH_SHORT).show()
            } else {
                val db = Firebase.firestore
                db.collection("authMedicines")
                    .document(uniqueId)
                    .get()
                    .addOnSuccessListener { document ->
                        if(document.exists()) {
                            val certifiedMedIntent = Intent(this, AdminCertifiedMed::class.java)
                            // using putExtra method I'm putting a key-value pair
                            // that is for the [uniqueId], and I'm then passing it to the
                            // CertifiedMedicine activity
                            certifiedMedIntent.putExtra("UNIQUE_ID", uniqueId)
                            startActivity(certifiedMedIntent)
                        }
                        else {
                            uniqueIdWidget.setText("")
                            val fakeMedIntent = Intent(this, FakeMedicine::class.java)
                            fakeMedIntent.putExtra("UNIQUE_ID", uniqueId)
                            startActivity(fakeMedIntent)
                        }
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "db access error", Toast.LENGTH_LONG).show()
                    }


            }

        }
    }
}