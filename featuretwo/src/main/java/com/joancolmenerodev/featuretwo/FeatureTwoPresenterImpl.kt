package com.joancolmenerodev.featuretwo

import com.joancolmenerodev.navigation.di.NavigationAction
import com.joancolmenerodev.navigation.di.NavigationStarter
import javax.inject.Inject

interface FeatureTwoContract {

    interface Presenter {
        fun goBack()
    }

    interface View {
        fun showMessage(message: String)
    }
}

interface FromFeatureTwo {
    fun openFeatureOne(): NavigationAction
}

class FeatureTwoPresenterImpl @Inject constructor(
    private val view: FeatureTwoContract.View,
    private val navigationStarter: NavigationStarter,
    private val fromFeatureTwo: FromFeatureTwo,
) : FeatureTwoContract.Presenter {

    override fun goBack() {
        view.showMessage("See you later alligator!")
        navigationStarter.start(fromFeatureTwo.openFeatureOne())
    }
}