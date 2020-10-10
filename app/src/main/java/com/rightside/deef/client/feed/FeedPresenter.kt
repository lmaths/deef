package com.rightside.deef.client.feed

import com.rightside.deef.base.BaseSchedulerProvider
import com.rightside.deef.models.Post
import io.reactivex.disposables.CompositeDisposable

class FeedPresenter(var schedulerProvider: BaseSchedulerProvider, val service : FeedContract.FirebaseService) : FeedContract.Presenter{
    override lateinit var view: FeedContract.View
    private val disposable = CompositeDisposable()

    override fun sendPost(post: Post) {
        service.sendPost(post).addOnSuccessListener { onSuccessPost()}
            .addOnFailureListener {  }
    }

    private fun onSuccessPost() {
        view.hideLoading()
        view.showAlertPostSend()
    }

    override fun getFeed() {
        view.showLoading()
        disposable.add(
            service.getPosts().subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(
                {
                    view.hideLoading()
                    onSuccessGetPosts(it)
                }, {
                        onFailurePosts(it)
                    }
                )
        )
    }

    private fun onFailurePosts(it: Throwable?) {
        view.showError()
    }

    private fun onSuccessGetPosts(it: List<Post>) {
        view.updateListPosts(it)
    }

    override fun start() {
        getFeed()
    }



}