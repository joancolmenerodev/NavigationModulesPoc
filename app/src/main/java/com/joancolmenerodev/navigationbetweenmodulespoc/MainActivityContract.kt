package com.joancolmenerodev.navigationbetweenmodulespoc

interface MainActivityContract {

    interface View {

    }

    interface Presenter {
        fun onTap(title: String)
    }
}