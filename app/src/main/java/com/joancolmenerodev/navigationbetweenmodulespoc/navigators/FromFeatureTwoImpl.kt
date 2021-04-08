package com.joancolmenerodev.navigationbetweenmodulespoc.navigators

import android.content.Context
import android.content.Intent
import com.joancolmenerodev.featureone.FeatureOneActivity
import com.joancolmenerodev.featuretwo.FromFeatureTwo
import com.joancolmenerodev.navigation.di.NavigationAction
import javax.inject.Inject

class FromFeatureTwoImpl @Inject constructor(private val context: Context) : FromFeatureTwo {

    override fun openFeatureOne() =
        NavigationAction(FeatureOneActivity.buildIntent(context))
}