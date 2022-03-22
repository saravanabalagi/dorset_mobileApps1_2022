package com.saravanabalagi.helloworldapplication

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.saravanabalagi.helloworldapplication.dataTypes.Location
import com.saravanabalagi.helloworldapplication.dataTypes.Post
import kotlinx.android.synthetic.main.activity_secondary.*
import okhttp3.*
import java.io.IOException

const val THIRD_ACT_KEY = "ThirdActivity"
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

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == AppCompatActivity.RESULT_OK) {
                val positionResult = it.data?.getIntExtra(POST_INDEX, -1)
                Toast.makeText(this, "Position received $positionResult", Toast.LENGTH_LONG).show()
                if (positionResult != null && positionResult >= 0)
                    posts_recycler_view.adapter?.notifyItemChanged(positionResult)
            }
        }

        posts_recycler_view.layoutManager = LinearLayoutManager(this)
        posts_recycler_view.adapter = PostsAdapter(posts, resultLauncher, this)

        stylegan2_link.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://arxiv.org/abs/1912.04958"))
            startActivity(intent)
        }

        val client = OkHttpClient()
        val request = Request.Builder().url("https://jsonplaceholder.typicode.com/users").build()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(THIRD_ACT_KEY, "Exception: $e")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val body = response.body?.string()
                    Log.i(THIRD_ACT_KEY, "Body: $body")
                }
            }
        })
    }
}