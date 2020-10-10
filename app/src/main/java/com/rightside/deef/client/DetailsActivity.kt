package com.rightside.deef.client

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.rightside.deef.R
import com.rightside.deef.client.model.Product
import com.rightside.deef.models.Post
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val post = intent.extras?.getSerializable("post") as Post

        imageButton_back.setOnClickListener(View.OnClickListener { finish() })
        Glide.with(applicationContext)
            .load(post.photoProductUrl)
            .into(imageView_product_image)
        showFragment(OfferFragment(), "ofertas")
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                if (tab.position == 0) {
                    showFragment(OfferFragment(), "ofertas")
                } else {
                    showFragment(CommentsFragment(), "comentarios")
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun showFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment, tag).commit()
    }
}