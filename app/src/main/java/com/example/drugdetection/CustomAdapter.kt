package com.example.drugdetection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.drugdetection.PrevStation
import com.example.drugdetection.R

// my Sdapter class will inherit "RecyclerView.Adapter" class
class CustomAdapter : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>(){
    private val items : ArrayList<PrevStation> = ArrayList()

    // first create a view holder subclass ->
    // my View Holder class will inherit "RecyclerView.ViewHolder" class
    class CustomViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        // defines views present in the item_station xml
        val station : TextView = itemView.findViewById(R.id.station)
        val stationId : TextView = itemView.findViewById(R.id.stationId)

    }

    // these three function have to be overriden(you have to provide your own definitions)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_station, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem = items[position]
        holder.station.text = currentItem.station
        holder.stationId.text = currentItem.stationId

    }

    fun updatePrevStations(updatedStations : ArrayList<PrevStation>) {

        items.clear()
        items.addAll(updatedStations)

        notifyDataSetChanged()
    }

}