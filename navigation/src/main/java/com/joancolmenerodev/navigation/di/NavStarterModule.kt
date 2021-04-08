package com.joancolmenerodev.navigation.di

import android.app.Activity
import android.content.Intent
import dagger.Module
import dagger.Provides

@Module
class NavigationStarterModule {

    @Provides
    fun providesNavigationStarter(activity: Activity): NavigationStarter =
        NavigationStarterImpl(activity)
}

interface NavigationStarter {
    fun start(navigationAction: NavigationAction)
}

class NavigationStarterImpl(private val activity: Activity) : NavigationStarter {
    override fun start(navigationAction: NavigationAction) = navigationAction.start(activity)
}

class NavigationAction(private val intent: Intent) {
    fun start(activity: Activity) = activity.startActivity(intent)
}