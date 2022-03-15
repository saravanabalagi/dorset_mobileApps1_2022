package com.saravanabalagi.helloworldapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_secondary.*

class ThirdActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)
        welcome_text.text = "Third"
        welcome_text.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        val nameStrings = arrayOf("Liam", "Olivia", "Noah", "Emma", "Oliver", "Ava", "Elijah", "Charlotte")
        val locationStrings = arrayOf("Belfast", "Doolin", "Dublin", "Killarney", "Galway", "Kinsale", "Westport", "Adare")

        val posts = Array<Post>(nameStrings.size) {
            Post().apply {
                name = nameStrings[it]
                location = Location().apply {
                    city = locationStrings[it]
                    country = "Ireland"
                }
            }
        }

        countries_recycler_view.layoutManager = LinearLayoutManager(this)
        countries_recycler_view.adapter = CountriesAdapter(posts, this)
    }
}

class Post {
    var name: String = "No name given"
    var location: Location = Location()
    var numLikes: Int = 0

    override fun toString(): String {
        return "$name ($location)"
    }
}

class Location {
    var city: String = "No city"
    var country: String = "No country"

    override fun toString(): String {
        return "$city, $country"
    }
}