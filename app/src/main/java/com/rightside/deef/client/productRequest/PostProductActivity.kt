package com.rightside.deef.client.productRequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rightside.deef.R
import com.rightside.deef.client.feed.FeedContract
import com.rightside.deef.client.feed.FeedPresenter
import com.rightside.deef.client.feed.adapter.ProductAdapter
import com.rightside.deef.client.model.Product
import com.rightside.deef.client.model.Status
import com.rightside.deef.models.Post
import com.rightside.deef.models.User
import kotlinx.android.synthetic.main.activity_post_product.*
import kotlinx.android.synthetic.main.fragment_feed.*
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
import java.util.*

class PostProductActivity : AppCompatActivity(),FeedContract.View {
    override val presenter: FeedPresenter by inject()
    lateinit var productAdapter : ProductAdapter
    private var productName : String = ""
    private var productUrl : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_product)
        presenter.view = this
        productAdapter = ProductAdapter(this) {
            productName = it.name
            productUrl = it.photoUrl
            edit_text_post.setText("Estou a procura de ${it.name}")
        }
        recyclerView_products_helper.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_products_helper.adapter = productAdapter
        edit_text_post.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(product: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("teste", product.toString())
               presenter.getProducts(product.toString())
                //LISTAMOS PRODUTOS SUGERIDOS DE ACORDO COM O DIGITADO
            }
            override fun afterTextChanged(p0: Editable?) {}

        })

        button_send_post.setOnClickListener {
            val currentTime: String = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(
                Date()
            )
            val time = System.currentTimeMillis()
            val randomUuid = UUID.randomUUID()
            val uuid = randomUuid.toString()
            presenter.sendPost(
                Post(
                    edit_text_post.text.toString(),
                    true,
                    currentTime,
                    time,
                    Status.OFERTA,
                    productName,
                    productUrl,
                    uuid,
                    User(
                        "Matheus",
                        "https://images-na.ssl-images-amazon.com/images/I/51VEQD%2BgTVL._AC_SX425_.jpg"
                    )
                )
            )
        }
    }

    override fun updateListProducts(products: List<Product>) {
        Log.d("teste", products.size.toString())
        text_view_help.visibility = View.VISIBLE
        recyclerView_products_helper.visibility = View.VISIBLE
        productAdapter.updateProducts(products)
    }

    override fun showLoading() {
        progress_bar_post.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress_bar_post.visibility = View.INVISIBLE
    }

    override fun showAlertPostSend() {
        Toast.makeText(this, "Sua publicação foi postada e em breve retornaremos", Toast.LENGTH_SHORT).show()
        //exibir alerta da publicação postada com melhor visual, finalizar a activity sei lá
    }
}