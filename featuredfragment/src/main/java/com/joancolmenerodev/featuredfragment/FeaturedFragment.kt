package com.joancolmenerodev.featuredfragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class FeaturedFragment : Fragment(R.layout.featured_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        private const val ARG_FEATURED_FRAGMENT = "arg_featured_fragment"
        fun newInstance(title: String): FeaturedFragment {
            return FeaturedFragment().apply {
                arguments = bundleOf(ARG_FEATURED_FRAGMENT to title)
            }

        }
    }
}