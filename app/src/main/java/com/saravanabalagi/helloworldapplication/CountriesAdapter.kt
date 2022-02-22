package com.saravanabalagi.helloworldapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountriesAdapter(val listItems: Array<String>): RecyclerView.Adapter<CountriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.countries_recycler_template, parent, false)
        return CountriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.countries_text_view).text = listItems[position]
    }

    override fun getItemCount(): Int {
        return countriesStrings.size
    }

}

class CountriesViewHolder(val v: View): RecyclerView.ViewHolder(v)