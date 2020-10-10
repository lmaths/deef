package com.rightside.deef.client.feed.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rightside.deef.R
import com.rightside.deef.client.model.Status
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
        val textViewProductName : TextView = holder.itemView.findViewById(R.id.textView_post_product_name)
        val imageViewUser : ImageView = holder.itemView.findViewById(R.id.imageView_post_user_image)
        val textViewUserName : TextView = holder.itemView.findViewById(R.id.textView_post_user_name)
        val imageViewStatus : ImageView = holder.itemView.findViewById(R.id.imageView_post_status)
        val imageViewVisibility : ImageView = holder.itemView.findViewById(R.id.imageView_visibility)
        textViewPostDescription.text = post.content
        textViewPostTime.text = post.date
        Glide.with(context).load(post.photoProductUrl).into(imageViewPhotoFeed)
        textViewProductName.text = post.productName
        textViewUserName.text = post.user.name
        Glide.with(context).load(post.user.photoUrl).circleCrop().into(imageViewUser)

        when(post.status) {
            Status.COMPRADO -> {
                imageViewStatus.setImageResource(R.drawable.ic_money)
            }
            Status.OFERTA -> {
                imageViewStatus.setImageResource(R.drawable.ic_shop)
            }
            Status.PESQUISANDO -> {
                imageViewStatus.setImageResource(R.drawable.ic_search)
            }
        }

        if(post.isPrivate) {
            imageViewVisibility.setImageResource(R.drawable.ic_lock)
        } else {
            imageViewVisibility.setImageResource(R.drawable.ic_public)
        }
    }
}