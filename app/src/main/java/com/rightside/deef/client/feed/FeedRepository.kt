package com.rightside.deef.client.feed
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.rightside.deef.models.Post
import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable


class FeedRepository(var database : FirebaseFirestore) : FeedContract.FirebaseService {
    override fun sendPost(post: Post): Task<DocumentReference> {
       return database.collection("posts").add(post.returnPost)
    }

    override fun getPosts(): Observable<List<Post>> {
        return Observable.create { emitter ->
            database.collection("posts").orderBy("timeInMili").addSnapshotListener { value, error ->
                value?.toObjects(Post::class.java)?.let { emitter.onNext(it) }
            }
        }
        }

}