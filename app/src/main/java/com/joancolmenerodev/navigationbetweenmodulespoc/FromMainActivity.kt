package com.joancolmenerodev.navigationbetweenmodulespoc

import com.joancolmenerodev.navigation.di.NavigationAction

interface FromMainActivity {
    fun openFeaturedFragment(title: String): NavigationAction
}