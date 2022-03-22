package com.saravanabalagi.helloworldapplication

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.*
import androidx.recyclerview.widget.RecyclerView
import com.saravanabalagi.helloworldapplication.dataTypes.Post
import com.squareup.picasso.MemoryPolicy
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
        if (post.numLikes > 0) {
            heartIcon.setColorFilter(getColor(context, R.color.red))
            numLikesTextView.visibility = View.VISIBLE
        } else numLikesTextView.visibility = View.GONE

        val imageView = holder.itemView.findViewById<ImageView>(R.id.image)
        val dpImageView = holder.itemView.findViewById<ImageView>(R.id.dp)

        val dpUrl = "https://thispersondoesnotexist.com/image"
        Picasso.get()
            .load(dpUrl)
            .placeholder(getDrawable(context, R.drawable.coffee)!!)
            .error(getDrawable(context, R.drawable.ic_baseline_error_24)!!)
            .memoryPolicy(MemoryPolicy.NO_CACHE)
            .into(dpImageView)

        val imageUrl = "https://thiscatdoesnotexist.com"
        Picasso.get()
            .load(imageUrl)
            .placeholder(getDrawable(context, R.drawable.coffee)!!)
            .error(getDrawable(context, R.drawable.ic_baseline_error_24)!!)
            .memoryPolicy(MemoryPolicy.NO_CACHE)
            .into(imageView)

//            This is bad! Don't network on main thread
//            val inputStream = URL(dpUrl).openStream()
//            val drawable = Drawable.createFromStream(inputStream, "Pixabay")
//            dpImageView.setImageDrawable(drawable)

        holder.itemView.findViewById<ImageView>(R.id.like_button).setOnClickListener {
            post.numLikes += 1
            notifyItemChanged(position)
//            notifyDataSetChanged()
        }

        imageView.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(POST_INDEX, position)
            (context as ThirdActivity).startActivityForResult(intent, 1000)
//            val intent = Intent(context, MainActivity::class.java)
//            startActivity(context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

}

class PostsViewHolder(val v: View): RecyclerView.ViewHolder(v)