package com.joancolmenerodev.navigationbetweenmodulespoc

import com.joancolmenerodev.navigation.di.NavigationStarter
import javax.inject.Inject

class MainActivityPresenterImpl @Inject constructor(
    private val starter: NavigationStarter,
    private val fromMainActivity: FromMainActivity
) :
    MainActivityContract.Presenter {

    override fun onTap(title: String) {
        starter.start(
            fromMainActivity.openFeaturedFragment(title)
        )
    }


}