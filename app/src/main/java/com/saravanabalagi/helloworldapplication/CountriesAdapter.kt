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

class CountriesAdapter(private val posts: Array<Post>, private val context: Context): RecyclerView.Adapter<CountriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.countries_recycler_template, parent, false)
        return CountriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val post = posts[position]
        holder.itemView.findViewById<TextView>(R.id.poster_name).text = post.name
        holder.itemView.findViewById<TextView>(R.id.poster_location).text = post.location.toString()

        val numLikesTextView = holder.itemView.findViewById<TextView>(R.id.num_likes)
        numLikesTextView.text = post.numLikes.toString()

        holder.itemView.findViewById<ImageView>(R.id.like_button).setOnClickListener {
            post.numLikes += 1
            numLikesTextView.text = post.numLikes.toString()
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

}

class CountriesViewHolder(val v: View): RecyclerView.ViewHolder(v)