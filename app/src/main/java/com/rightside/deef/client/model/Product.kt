package com.rightside.deef.client.model

import java.io.Serializable

data class Product(val name : String = "", val brand : String = "", val category: Category = Category.TELEVISAO, val price : String = "", val portionPrice : String = "", val id : String = "", val photoUrl : String = "") : Serializable {
    val map = hashMapOf(
        Pair("name", name),
        Pair("brand", brand),
        Pair("category", category),
        Pair("price", price),
        Pair("portionPrice", portionPrice),
        Pair("id", id),
        Pair("photoUrl", photoUrl)
    )
}
