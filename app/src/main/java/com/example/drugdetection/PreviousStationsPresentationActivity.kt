package com.example.drugdetection

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PreviousStationsPresentationActivity : AppCompatActivity() {

    // define your adapter
    private lateinit var mAdapter : CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous_stations_presentation)

        val intent = intent
        val uniqueId = intent.getStringExtra("UNIQUE_ID")

        // get recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        // provide it with a layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)



        // instantiate your adapter
        mAdapter =  CustomAdapter()

        // fetch stations from firestore db
        fetchPreviousStations(uniqueId)

        // give adapter to your recycler view
        recyclerView.adapter = mAdapter


    }


    private fun fetchPreviousStations(uniqueId: String?) {


        val db = Firebase.firestore
        // get document from the db
            db.collection("authMedicines").document(uniqueId!!).get()
                .addOnSuccessListener {document ->
                    if(document != null) {
                        // this will be items arraylist in my adapter(CustomAdapter)
                        val stationsArray = ArrayList<PrevStation>()

                        // get specific entries :
                        val stations : ArrayList<String> = document.get("stations") as ArrayList<String>
                        val stationsId : ArrayList<String> = document.get("stationsId") as ArrayList<String>

                        stations.zip(stationsId).forEach {pair ->
                            val station = PrevStation(pair.component1(), pair.component2())
                            stationsArray.add(station)
                        }

//                        stationsArray = [{stations[0], stationsId[0]}, {stations[1], stationsId[1]}...]
//                        now passing this entire stationsArray to my adapter
                        mAdapter.updatePrevStations(stationsArray)

                    } else {
                        // if no such document exists -> which is very improbable, but still
                        Toast.makeText(this, "no such document", Toast.LENGTH_LONG).show()
                    }

                }
                .addOnFailureListener {
                    Toast.makeText(this, "fetching from db failed", Toast.LENGTH_LONG).show()
                }

    }

}