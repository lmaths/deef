package com.rightside.deef.models

import androidx.annotation.Keep
import com.google.firebase.firestore.auth.User
import com.rightside.deef.client.model.Status
import java.io.Serializable
@Keep
data class Post(val content : String = "", val isPrivate : Boolean = false, val date : String = "", val timeInMili : Long = 0, val status : Status = Status.PESQUISANDO, val productName : String = "", val photoProductUrl : String = "", val id: String = "",val user: com.rightside.deef.models.User = User("", "")) : Serializable {
    val map = hashMapOf(
        Pair("content", content),
        Pair("isPrivate", isPrivate),
        Pair("date", date),
        Pair("timeInMili", timeInMili),
        Pair("status", status),
        Pair("photoProductUrl", photoProductUrl),
        Pair("id", id),
        Pair("user", user.map),
        Pair("productName", productName)
    )

}