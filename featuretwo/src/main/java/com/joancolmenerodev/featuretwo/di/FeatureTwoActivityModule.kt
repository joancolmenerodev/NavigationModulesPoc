package com.joancolmenerodev.featuretwo.di

import android.app.Activity
import com.joancolmenerodev.featuretwo.FeatureTwoActivity
import com.joancolmenerodev.featuretwo.FeatureTwoContract
import com.joancolmenerodev.featuretwo.FeatureTwoPresenterImpl
import dagger.Binds
import dagger.Module

@Module
abstract class FeatureTwoActivityModule {
    @Binds
    abstract fun bindView(
        impl: FeatureTwoActivity
    ): FeatureTwoContract.View

    @Binds
    abstract fun bindActivity(impl: FeatureTwoActivity): Activity

    @Binds
    abstract fun bindPresenter(
        impl: FeatureTwoPresenterImpl
    ): FeatureTwoContract.Presenter
}