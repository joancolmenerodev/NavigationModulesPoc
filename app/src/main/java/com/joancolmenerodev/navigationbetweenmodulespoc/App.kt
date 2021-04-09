package com.joancolmenerodev.navigationbetweenmodulespoc

import android.app.Application
import com.joancolmenerodev.featureone.di.DaggerFeatureOneComponent
import com.joancolmenerodev.featureone.di.FeatureOneComponent
import com.joancolmenerodev.featureone.di.FeatureOneComponentProvider
import com.joancolmenerodev.featuretwo.di.DaggerFeatureTwoComponent
import com.joancolmenerodev.featuretwo.di.FeatureTwoComponent
import com.joancolmenerodev.featuretwo.di.FeatureTwoComponentProvider
import com.joancolmenerodev.navigationbetweenmodulespoc.navigators.FromFeatureOneImpl
import com.joancolmenerodev.navigationbetweenmodulespoc.navigators.FromFeatureTwoImpl

open class App : Application(), FeatureOneComponentProvider, FeatureTwoComponentProvider {

    //This in our case should be on AppComponent so each submodule would see it

    override val featureOneComponent: FeatureOneComponent
        get() = DaggerFeatureOneComponent.factory().create(FromFeatureOneImpl(applicationContext))

    override val featureTwoComponent: FeatureTwoComponent
        get() = DaggerFeatureTwoComponent.factory().create(FromFeatureTwoImpl(applicationContext))
}