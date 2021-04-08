package com.joancolmenerodev.featuretwo.di

import com.joancolmenerodev.featuretwo.FeatureTwoActivity
import com.joancolmenerodev.featuretwo.FromFeatureTwo
import dagger.BindsInstance
import dagger.Component

@Component
interface FeatureTwoComponent {

    fun featureTwoComponent(): FeatureTwoActivity.Component.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance from: FromFeatureTwo): FeatureTwoComponent
    }
}