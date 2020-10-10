package com.rightside.deef.client.feed

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rightside.deef.R
import com.rightside.deef.client.feed.adapter.FeedAdapter
import com.rightside.deef.models.Post
import kotlinx.android.synthetic.main.fragment_feed.*
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
import java.util.*


class FeedFragment : Fragment(R.layout.fragment_feed), FeedContract.View{
    override val presenter: FeedPresenter by inject()
    lateinit var feedAdapter : FeedAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        presenter.start()
        feedAdapter = FeedAdapter()
        recycler_view_feed.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        recycler_view_feed.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, true)
        recycler_view_feed.adapter = feedAdapter
        button_send_post.setOnClickListener {
            val currentTime: String = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date())
            val time = System.currentTimeMillis()
            presenter.sendPost(Post(edit_text_post.text.toString(), true, currentTime, time))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FeedFragment()
    }

    override fun showAlertPostSend() {

    }

    override fun updateListPosts(postList: List<Post>) {
        feedAdapter.updatePostsList(postList)
    }

    override fun showError() {

    }


    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }
}