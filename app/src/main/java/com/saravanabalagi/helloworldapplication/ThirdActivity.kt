package com.saravanabalagi.helloworldapplication

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1000 && resultCode == RESULT_OK) {
            val position = data?.getIntExtra(POST_INDEX, -1)
            if (position != null && position >= 0) {
                Toast.makeText(this, "Position received $position", Toast.LENGTH_LONG).show()
                posts_recycler_view.adapter?.notifyItemChanged(position)
            }
        }
    }
}