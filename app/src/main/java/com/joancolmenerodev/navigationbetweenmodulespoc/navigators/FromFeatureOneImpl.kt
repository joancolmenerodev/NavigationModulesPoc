package com.joancolmenerodev.navigationbetweenmodulespoc.navigators

import android.content.Context
import com.joancolmenerodev.featureone.FromFeatureOne
import com.joancolmenerodev.featuretwo.FeatureTwoActivity
import com.joancolmenerodev.navigation.di.NavigationAction
import javax.inject.Inject

class FromFeatureOneImpl @Inject constructor(private val context: Context) : FromFeatureOne {

    override fun openFeatureTwo(title: String, url: String) =
        NavigationAction.IntentNavigationAction(
            FeatureTwoActivity.buildIntent(context, title, url)
        )
}