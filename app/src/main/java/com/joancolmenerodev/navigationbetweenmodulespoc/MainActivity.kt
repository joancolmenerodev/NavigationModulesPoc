package com.joancolmenerodev.navigationbetweenmodulespoc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.joancolmenerodev.featureone.FeatureOneActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(FeatureOneActivity.buildIntent(this))
    }
}