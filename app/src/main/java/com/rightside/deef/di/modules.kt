package com.rightside.deef.di

import com.google.firebase.firestore.FirebaseFirestore
import com.rightside.deef.base.BaseSchedulerProvider
import com.rightside.deef.base.SchedulerProvider
import com.rightside.deef.client.feed.FeedContract
import com.rightside.deef.client.feed.FeedPresenter
import com.rightside.deef.client.feed.FeedRepository
import org.koin.dsl.module
val koinModule = module {
    factory { FirebaseFirestore.getInstance() }
    single<FeedContract.FirebaseService> {
        FeedRepository(database = get())
    }
    factory { FeedPresenter(schedulerProvider = get(), service = get() ) }


    single<BaseSchedulerProvider>{SchedulerProvider()}




}

