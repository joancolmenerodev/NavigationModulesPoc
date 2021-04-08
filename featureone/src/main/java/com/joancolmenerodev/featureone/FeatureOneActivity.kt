package com.joancolmenerodev.featureone

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.joancolmenerodev.featureone.di.FeatureOneComponentProvider
import com.joancolmenerodev.navigation.di.NavigationStarterModule
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import javax.inject.Inject

class FeatureOneActivity : AppCompatActivity(), FeatureOneContract.View {

    @Inject
    lateinit var presenter: FeatureOneContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_one)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            presenter.openWebsite(
                title = findViewById<AppCompatEditText>(R.id.et_title).text.toString(),
                url = findViewById<AppCompatEditText>(R.id.et_url).text.toString()
            )
        }
    }

    private fun inject() {
        (applicationContext as FeatureOneComponentProvider).featureOneComponent.featureOneComponent()
            .create(this).inject(this)
    }

    override fun showError(error: String) {
        Snackbar.make(findViewById(R.id.root), error, Snackbar.LENGTH_SHORT).show()
    }

    companion object {
        fun buildIntent(context: Context) =
            Intent(context, FeatureOneActivity::class.java)
    }

    @Module
    interface FeatureOneActivityModule {
        @Binds
        fun bindView(
            impl: FeatureOneActivity
        ): FeatureOneContract.View

        @Binds
        fun bindActivity(impl: FeatureOneActivity): Activity

        @Binds
        fun bindPresenter(
            impl: FeatureOnePresenterImpl
        ): FeatureOneContract.Presenter
    }

    @Subcomponent(modules = [FeatureOneActivityModule::class, NavigationStarterModule::class])
    interface Component {

        fun inject(activity: FeatureOneActivity)

        @Subcomponent.Factory
        interface Factory {
            fun create(@BindsInstance activity: FeatureOneActivity): Component
        }
    }
}