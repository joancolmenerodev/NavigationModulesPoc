package com.joancolmenerodev.featureone

import com.joancolmenerodev.navigation.di.NavigationAction
import com.joancolmenerodev.navigation.di.NavigationStarter
import javax.inject.Inject

interface FeatureOneContract {

    interface Presenter {
        fun openWebsite(title: String?, url: String?)
    }

    interface View {
        fun showError(error: String)
    }
}

interface FromFeatureOne {
    fun openFeatureTwo(title: String, url: String): NavigationAction
}

class FeatureOnePresenterImpl @Inject constructor(
    private val view: FeatureOneContract.View,
    private val navigationStarter: NavigationStarter,
    private val fromFeatureOne: FromFeatureOne
) : FeatureOneContract.Presenter {

    override fun openWebsite(title: String?, url: String?) {
        if (title.isNullOrEmpty() || url.isNullOrEmpty()) {
            view.showError("Title or Url shouldn't be empty!")
        } else {
            navigationStarter.start(fromFeatureOne.openFeatureTwo(title, url))
        }
    }
}