package com.rightside.deef

import android.app.Application
import com.rightside.deef.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import java.util.ArrayList

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val modules : MutableList<Module> = ArrayList()
        modules.add(koinModule)
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(modules)
        }
    }
}