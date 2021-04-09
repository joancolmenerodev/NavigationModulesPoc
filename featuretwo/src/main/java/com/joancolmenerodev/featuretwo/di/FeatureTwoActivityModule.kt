package com.joancolmenerodev.featuretwo.di

import android.app.Activity
import com.joancolmenerodev.featuretwo.FeatureTwoActivity
import com.joancolmenerodev.featuretwo.FeatureTwoContract
import com.joancolmenerodev.featuretwo.FeatureTwoPresenterImpl
import dagger.Binds
import dagger.Module

@Module
interface FeatureTwoActivityModule {
    @Binds
    fun bindView(
        impl: FeatureTwoActivity
    ): FeatureTwoContract.View

    @Binds
    fun bindActivity(impl: FeatureTwoActivity): Activity

    @Binds
    fun bindPresenter(
        impl: FeatureTwoPresenterImpl
    ): FeatureTwoContract.Presenter
}