package com.rightside.deef.models

import androidx.annotation.Keep
import java.io.Serializable
@Keep
data class Post(val content : String = "", val isPrivate : Boolean = false, val date : String = "", val timeInMili : Long = 0) : Serializable {
    val returnPost = hashMapOf(
        Pair("content", content),
        Pair("isPrivate", isPrivate),
        Pair("date", date),
        Pair("timeInMili", timeInMili)
    )

}