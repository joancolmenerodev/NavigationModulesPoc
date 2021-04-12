package com.joancolmenerodev.navigationbetweenmodulespoc

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.joancolmenerodev.featuredfragment.FeaturedFragment
import com.joancolmenerodev.navigation.di.NavigationAction
import com.joancolmenerodev.navigation.di.NavigationStarter
import com.joancolmenerodev.navigation.di.NavigationStarterModule
import com.joancolmenerodev.navigationbetweenmodulespoc.di.MainActivityModule
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var starter: NavigationStarter

    lateinit var toolbar: ActionBar
    private val navigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_alert -> {
                    starter.start(
                        NavigationAction.FragmentNavigationAction(
                            fragmentManager = this.supportFragmentManager,
                            frameId = R.id.container,
                            fragment = FeaturedFragment.newInstance("hello")
                        )
                    )
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_low_battery -> {
                    toolbar.title = "Low Battery"
                    val artistsFragment = LowBatteryFragment.newInstance()
                    openFragment(artistsFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        //startActivity(FeatureOneActivity.buildIntent(this))
    }

    @Subcomponent(modules = [MainActivityModule::class, NavigationStarterModule::class])
    interface Component {
        fun inject(activity: MainActivity)

        @Subcomponent.Factory
        interface Factory {
            fun create(@BindsInstance activity: MainActivity): Component
        }
    }
}