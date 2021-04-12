package com.joancolmenerodev.navigationbetweenmodulespoc.di

import android.app.Activity
import com.joancolmenerodev.featureone.FeatureOnePresenterImpl
import com.joancolmenerodev.navigationbetweenmodulespoc.MainActivity
import com.joancolmenerodev.navigationbetweenmodulespoc.MainActivityContract
import com.joancolmenerodev.navigationbetweenmodulespoc.MainActivityPresenterImpl
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule {
    @Binds
    abstract fun bindView(
        impl: MainActivity
    ): MainActivityContract.View

    @Binds
    abstract fun bindActivity(impl: MainActivity): Activity

    @Binds
    abstract fun bindPresenter(
        impl: MainActivityPresenterImpl
    ): MainActivityContract.Presenter
}