package com.rightside.deef.client.feed.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rightside.deef.R
import com.rightside.deef.models.Post
import org.w3c.dom.Text

class FeedAdapter(var context : Context) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    var posts : List<Post> = ArrayList()
    inner class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_feed, parent, false)
        )
    }

    override fun getItemCount() = posts.size

    fun updatePostsList(posts : List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val post = posts[position]
        val textViewPostDescription : TextView = holder.itemView.findViewById(R.id.text_view_post_description)
        val textViewPostTime : TextView = holder.itemView.findViewById(R.id.text_view_time)
        val imageViewPhotoFeed : ImageView = holder.itemView.findViewById(R.id.image_view_photo_feed)
        textViewPostDescription.text = post.content
        textViewPostTime.text = post.date
        Glide.with(context).load(post.photoProductUrl).into(imageViewPhotoFeed)
    }
}