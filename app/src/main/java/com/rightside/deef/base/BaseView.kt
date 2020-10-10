package com.rightside.deef.base

interface BaseView<out T : BasePresenter<*>> {
    val presenter : T
}