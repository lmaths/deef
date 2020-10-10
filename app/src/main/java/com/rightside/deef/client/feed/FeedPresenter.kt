package com.rightside.deef.client.feed

import com.rightside.deef.base.BaseSchedulerProvider
import com.rightside.deef.client.model.Category
import com.rightside.deef.client.model.Product
import com.rightside.deef.models.Post
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import kotlin.collections.ArrayList

class FeedPresenter(var schedulerProvider: BaseSchedulerProvider, val service : FeedContract.FirebaseService) : FeedContract.Presenter{
    override lateinit var view: FeedContract.View
    private val disposable = CompositeDisposable()

    override fun sendPost(post: Post) {
        service.sendPost(post).addOnSuccessListener { onSuccessPost()}
            .addOnFailureListener {  }
    }

    override fun createProductList() {
        val product : MutableList<Product> = ArrayList()
        product.add(Product("TV LG 42 POL", "LG", Category.TELEVISAO, "R$1500,00","Em até 12x de 202R$", "1","https://images-americanas.b2w.io/produtos/01/00/img/134444/7/134444758_1SZ.jpg"))
        product.add(Product("TV SAMSUNG", "LG", Category.TELEVISAO, "R$2600","Em até 12x de 150R$", "2", "https://samsungbr.vtexassets.com/arquivos/ids/312147-1200-auto?width=1200&height=auto&aspect=true"))
        product.add(Product("TV PHILIPS", "LG", Category.TELEVISAO, "R$1700","Em até 12x de 350R$", "3", "https://fujiokadistribuidor.vteximg.com.br/arquivos/ids/171560"))
        product.add(Product("TV SAMSUNG", "LG", Category.TELEVISAO, "R$2600","Em até 12x de 150R$", "4" , "https://images-americanas.b2w.io/produtos/01/00/img/1322119/1/1322119119_1SZ.jpg"))
        product.add(Product("Fogão Consul 4 bocas","Consul", Category.FOGAO, "R$900", "Em até 5x de 250R$", "5", "https://www.casasbahia-imagens.com.br/Control/ArquivoExibir.aspx?IdArquivo=796479410"))
        product.add(Product("Fogão SmartBrass 6 bocas","SMARTBRAS", Category.FOGAO, "R$1700", "R$1300", "6", "https://novomundo.vtexassets.com/arquivos/ids/1568024-500-500"))
        product.add(Product("Fogão SmartBrass 3 bocas","SMARTBRAS", Category.FOGAO, "R$1818", "R$1300", "6", "https://static.carrefour.com.br/medias/sys_master/images/images/h31/hfa/h00/h00/11119755362334.jpg"))
        product.add(Product("Fogão Itatiaia 5 bocas","SMARTBRAS", Category.FOGAO, "R$4848", "R$1300", "6", "https://www.casasbahia-imagens.com.br/html/conteudo-produto/13/11488712/images/Fogao-CFS5NAB-Consul-5-Bocas_.png"))
        service.saveProductList(product)
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

    override fun getProducts(productName : String) {
        view.showLoading()
        disposable.add(
            service.getProducts(productName.toUpperCase(Locale.ROOT)).subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(
                    {onSuccessGetProducts(it)},
                    {onFailureGetProducts(it)}
                )
        )
    }

    private fun onFailureGetProducts(it: Throwable?) {
        view.hideLoading()
    }


    private fun onSuccessGetProducts(productList: List<Product>) {
        view.hideLoading()
        if(productList.isNotEmpty()) {
            view.updateListProducts(productList)
        }

    }

    private fun onFailurePosts(it: Throwable?) {
        view.showError()
    }

    private fun onSuccessGetPosts(it: List<Post>) {
        view.updateListPosts(it)
    }

    override fun start() {
        createProductList()
        getFeed()
    }



}