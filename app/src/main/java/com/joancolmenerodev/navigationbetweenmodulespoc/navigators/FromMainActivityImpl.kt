package com.joancolmenerodev.navigationbetweenmodulespoc.navigators

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.joancolmenerodev.navigation.di.NavigationAction
import com.joancolmenerodev.navigationbetweenmodulespoc.FromMainActivity
import javax.inject.Inject

class FromMainActivityImpl @Inject constructor(private val context: Context) : FromMainActivity {

    override fun openFeaturedFragment(title: String): NavigationAction {
       return NavigationAction.FragmentNavigationAction(
           (context as AppCompatActivity).supportFragmentManager,

       )
    }
}
