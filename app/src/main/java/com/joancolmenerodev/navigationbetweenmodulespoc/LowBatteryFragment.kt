package com.joancolmenerodev.navigationbetweenmodulespoc

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LowBatteryFragment : Fragment(R.layout.low_battery_fragment) {

    companion object {
        fun newInstance(): LowBatteryFragment = LowBatteryFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<FloatingActionButton>(R.id.fab_fragment).setOnClickListener {

        }
    }
}