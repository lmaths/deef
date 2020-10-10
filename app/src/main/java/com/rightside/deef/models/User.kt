package com.rightside.deef.models

import java.io.Serializable

data class User(val name : String = "", val photoUrl : String = "") : Serializable {
    val map = hashMapOf(
        Pair("name", name),
        Pair("photoUrl", photoUrl)
    )
}