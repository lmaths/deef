package com.rightside.deef.client.feed

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ListenerRegistration
import com.rightside.deef.base.BaseInterface
import com.rightside.deef.base.BasePresenter
import com.rightside.deef.base.BaseView
import com.rightside.deef.client.model.Product
import com.rightside.deef.models.Post
import io.reactivex.Observable
import java.util.*

interface FeedContract {
    interface View : BaseView<Presenter>, BaseInterface.Fragment {
        fun showAlertPostSend() {}
        fun updateListPosts(postList : List<Post>) {}
        fun showError() {}
        fun updateListProducts(products: List<Product>){}
    }
    interface Presenter : BasePresenter<View> {
        fun sendPost(post : Post)
        fun createProductList()
        fun createOffers()
        fun getFeed()
        fun getProducts(productName: String)
    }
    interface FirebaseService {
        fun sendPost(post: Post) : Task<Void>
        fun saveProductList(products : List<Product>)
        fun getPosts() : Observable<List<Post>>
        fun getProducts(productName : String) : Observable<List<Product>>
    }
}