package com.joancolmenerodev.featureone.di

import com.joancolmenerodev.featureone.FeatureOneActivity
import com.joancolmenerodev.featureone.FromFeatureOne
import dagger.BindsInstance
import dagger.Component

@Component
interface FeatureOneComponent {

    fun featureOneComponent(): FeatureOneActivity.Component.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance from: FromFeatureOne): FeatureOneComponent
    }
}