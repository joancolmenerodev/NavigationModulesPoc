package com.joancolmenerodev.navigation.di

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
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
    override fun start(navigationAction: NavigationAction) {
        when (navigationAction) {
            is NavigationAction.IntentNavigationAction -> {
                activity.startActivity(navigationAction.intent)
            }
            is NavigationAction.FragmentNavigationAction -> {
                if (navigationAction.shouldBeAddedToBackStack) {
                    (activity as AppCompatActivity).supportFragmentManager.inTransaction {
                        addToBackStack(null)
                        replace(navigationAction.frameId, navigationAction.fragment)
                    }
                } else {
                    (activity as AppCompatActivity).supportFragmentManager.inTransaction {
                        replace(navigationAction.frameId, navigationAction.fragment)
                    }
                }
            }
        }
    }
}

/*
   This class could be converted to an interface or sealed class and instead of use startActivity choose wheter start an Activity or Fragment
 */
sealed class NavigationAction {
    data class IntentNavigationAction(val intent: Intent) : NavigationAction()
    data class FragmentNavigationAction(
        val frameId: Int,
        val fragment: Fragment,
        val shouldBeAddedToBackStack: Boolean = true
    ) : NavigationAction()
}

private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commitAllowingStateLoss()
}