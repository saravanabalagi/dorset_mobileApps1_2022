package com.saravanabalagi.helloworldapplication

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.saravanabalagi.helloworldapplication.dataTypes.Location
import com.saravanabalagi.helloworldapplication.dataTypes.Post
import kotlinx.android.synthetic.main.activity_secondary.*

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

class ThirdActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        countries_list_view.visibility = View.GONE
        welcome_text.text = "Third"
        welcome_text.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        posts_recycler_view.layoutManager = LinearLayoutManager(this)
        posts_recycler_view.adapter = PostsAdapter(posts, this)

        stylegan2_link.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://arxiv.org/abs/1912.04958"))
            startActivity(intent)
        }
    }
}