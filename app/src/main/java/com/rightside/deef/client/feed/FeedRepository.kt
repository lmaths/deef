package com.rightside.deef.client.feed
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.rightside.deef.client.model.Product
import com.rightside.deef.models.Post
import io.reactivex.Observable


class FeedRepository(var database : FirebaseFirestore) : FeedContract.FirebaseService {
    override fun sendPost(post: Post): Task<Void> {
       return database.collection("posts").document(post.id).set(post.map)
    }

    override fun saveProductList(products: List<Product>) {
        products.forEach {
            database.collection("products").document(it.id).set(it.map)
        }

    }

    override fun getPosts(): Observable<List<Post>> {
        return Observable.create { emitter ->
            database.collection("posts").orderBy("timeInMili").addSnapshotListener { value, error ->
                value?.toObjects(Post::class.java)?.let { emitter.onNext(it) }
            }
        }
        }

    override fun getProducts(productName : String): Observable<List<Product>> {
        return Observable.create { emitter ->
            database.collection("products").whereEqualTo("category",productName).addSnapshotListener{value, error ->
                value?.toObjects(Product::class.java)?.let { emitter.onNext(it) }
            }
        }
    }

}