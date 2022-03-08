package com.saravanabalagi.helloworldapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CountriesAdapter(val nameStrings: Array<String>, val locationStrings: Array<String>, val context: Context): RecyclerView.Adapter<CountriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.countries_recycler_template, parent, false)
        return CountriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.poster_name).text = nameStrings[position]
        holder.itemView.findViewById<TextView>(R.id.poster_location).text = locationStrings[position] + ", Ireland"
        holder.itemView.findViewById<ImageView>(R.id.like_button).setOnClickListener {
            Toast.makeText(context, "Hi there $position", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return nameStrings.size
    }

}

class CountriesViewHolder(val v: View): RecyclerView.ViewHolder(v)