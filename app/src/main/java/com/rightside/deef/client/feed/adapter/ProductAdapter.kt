package com.rightside.deef.client.feed.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rightside.deef.R
import com.rightside.deef.client.model.Product


class ProductAdapter(var context : Context, var click : (Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var products : List<Product> = ArrayList()
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
       return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        val textViewProductName : TextView = holder.itemView.findViewById(R.id.textView_product_name)
        val textViewProductPrice : TextView = holder.itemView.findViewById(R.id.textView_product_price)
        val textViewProductPortion : TextView = holder.itemView.findViewById(R.id.textView_product_portion)
        val imageViewProduct : ImageView = holder.itemView.findViewById(R.id.image_view_product_photo)
        textViewProductName.text = product.name
        textViewProductPrice.text = product.price
        textViewProductPortion.text = product.portionPrice
        Glide.with(context).load(product.photoUrl).into(imageViewProduct)
        holder.itemView.setOnClickListener { click(product) }
    }

    override fun getItemCount() = products.size

    fun updateProducts(products : List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }
}