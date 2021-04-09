package com.joancolmenerodev.featureone.di

import android.app.Activity
import com.joancolmenerodev.featureone.FeatureOneActivity
import com.joancolmenerodev.featureone.FeatureOneContract
import com.joancolmenerodev.featureone.FeatureOnePresenterImpl
import dagger.Binds
import dagger.Module

@Module
interface FeatureOneActivityModule {
    @Binds
    fun bindView(
        impl: FeatureOneActivity
    ): FeatureOneContract.View

    @Binds
    fun bindActivity(impl: FeatureOneActivity): Activity

    @Binds
    fun bindPresenter(
        impl: FeatureOnePresenterImpl
    ): FeatureOneContract.Presenter
}