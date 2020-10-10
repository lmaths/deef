package com.rightside.deef.base

interface BasePresenter<T> {
    fun start()
    var view : T
}