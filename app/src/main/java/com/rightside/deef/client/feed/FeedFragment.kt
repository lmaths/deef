package com.rightside.deef.client.feed

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rightside.deef.R
import com.rightside.deef.client.feed.adapter.FeedAdapter
import com.rightside.deef.client.model.Status
import com.rightside.deef.client.productRequest.PostProductActivity
import com.rightside.deef.databinding.FragmentFeedBinding
import com.rightside.deef.models.Post
import com.rightside.deef.models.User
import kotlinx.android.synthetic.main.fragment_feed.*
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
import java.util.*


class FeedFragment : Fragment(), FeedContract.View{
    override val presenter: FeedPresenter by inject()
    private lateinit var feedAdapter : FeedAdapter
    private lateinit var binding : FragmentFeedBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        presenter.start()
        feedAdapter = FeedAdapter(requireContext())
        binding.recyclerViewFeed.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )
        binding.recyclerViewFeed.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            true
        )
        binding.recyclerViewFeed.adapter = feedAdapter
        binding.floatingActionButtonFeed.setOnClickListener {
            startActivity(Intent(context, PostProductActivity::class.java))
            activity?.overridePendingTransition(R.anim.nav_default_enter_anim, R.anim.nav_default_exit_anim);
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
        progressBar.visibility = View.INVISIBLE
    }
}