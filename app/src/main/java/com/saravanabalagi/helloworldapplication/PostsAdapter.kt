package com.saravanabalagi.helloworldapplication

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.ContextCompat.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.saravanabalagi.helloworldapplication.dataTypes.Post
import com.squareup.picasso.Picasso
import java.io.InputStream
import java.net.URL

class PostsAdapter(private val posts: Array<Post>, private val context: Context): RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = inflator.inflate(R.layout.posts_recycler_template, parent, false)
        return PostsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = posts[position]
        holder.itemView.findViewById<TextView>(R.id.poster_name).text = post.name
        holder.itemView.findViewById<TextView>(R.id.poster_location).text = post.location.toString()

        val numLikesTextView = holder.itemView.findViewById<TextView>(R.id.num_likes)
        val heartIcon = holder.itemView.findViewById<ImageView>(R.id.like_button)
        numLikesTextView.text = post.numLikes.toString()

        val imageView = holder.itemView.findViewById<ImageView>(R.id.image)
        val dpImageView = holder.itemView.findViewById<ImageView>(R.id.dp)

        if (position == 0) {

//            val dpUrl = "https://cdn.pixabay.com/photo/2020/09/26/07/05/sea-5603351_960_720.jpg"
            val dpUrl = "https://cdn.pixabay.com/photo/2022/03/01/20/58/peace-genius-7042013_960_720.jpg"
            Picasso.get()
                .load(dpUrl)
                .placeholder(getDrawable(context, R.drawable.coffee)!!)
                .error(getDrawable(context, R.drawable.ic_baseline_error_24)!!)
                .into(dpImageView)

//            This is bad! Don't network on main thread
//            val inputStream = URL(dpUrl).openStream()
//            val drawable = Drawable.createFromStream(inputStream, "Pixabay")
//            dpImageView.setImageDrawable(drawable)

        }

        holder.itemView.findViewById<ImageView>(R.id.like_button).setOnClickListener {
            post.numLikes += 1
            numLikesTextView.text = post.numLikes.toString()
            if (post.numLikes > 0) {
                heartIcon.setBackgroundColor(getColor(context, R.color.red))
                numLikesTextView.visibility = View.VISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

}

class PostsViewHolder(val v: View): RecyclerView.ViewHolder(v)