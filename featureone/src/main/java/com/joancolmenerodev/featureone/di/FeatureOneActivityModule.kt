package com.joancolmenerodev.featureone.di

import android.app.Activity
import com.joancolmenerodev.featureone.FeatureOneActivity
import com.joancolmenerodev.featureone.FeatureOneContract
import com.joancolmenerodev.featureone.FeatureOnePresenterImpl
import dagger.Binds
import dagger.Module

@Module
abstract class FeatureOneActivityModule {
    @Binds
    abstract fun bindView(
        impl: FeatureOneActivity
    ): FeatureOneContract.View

    @Binds
    abstract fun bindActivity(impl: FeatureOneActivity): Activity

    @Binds
    abstract fun bindPresenter(
        impl: FeatureOnePresenterImpl
    ): FeatureOneContract.Presenter
}