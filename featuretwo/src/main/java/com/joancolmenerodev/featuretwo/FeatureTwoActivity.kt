package com.joancolmenerodev.featuretwo

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.snackbar.Snackbar
import com.joancolmenerodev.featuretwo.di.FeatureTwoActivityModule
import com.joancolmenerodev.featuretwo.di.FeatureTwoComponentProvider
import com.joancolmenerodev.navigation.di.NavigationStarterModule
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import javax.inject.Inject

class FeatureTwoActivity : AppCompatActivity(), FeatureTwoContract.View {

    @Inject
    lateinit var presenter: FeatureTwoContract.Presenter

    private val title by lazy {
        intent.extras?.getString(TITLE_ARGS)
    }

    private val url by lazy {
        intent.extras?.getString(URL_ARGS)
    }

    companion object {
        fun buildIntent(context: Context, title: String, url: String): Intent {
            return Intent(context, FeatureTwoActivity::class.java).apply {
                putExtra(TITLE_ARGS, title)
                putExtra(URL_ARGS, url)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_two)

        findViewById<AppCompatTextView>(R.id.tv_title).text = title
        findViewById<WebView>(R.id.webView).loadUrl(url!!)
    }

    private fun inject() {
        (applicationContext as FeatureTwoComponentProvider).featureTwoComponent.featureTwoComponent()
            .create(this).inject(this)
    }

    override fun showMessage(message: String) {
        Snackbar.make(findViewById(R.id.root), message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        presenter.goBack()
    }

    @Subcomponent(modules = [FeatureTwoActivityModule::class, NavigationStarterModule::class])
    interface Component {
        fun inject(activity: FeatureTwoActivity)

        @Subcomponent.Factory
        interface Factory {
            fun create(@BindsInstance activity: FeatureTwoActivity): Component
        }
    }
}

private const val TITLE_ARGS = "title"
private const val URL_ARGS = "url"