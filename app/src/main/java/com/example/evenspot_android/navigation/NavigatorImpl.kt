package com.example.evenspot_android.navigation

import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.navigation.Navigator

class NavigatorImpl : Navigator {

    private var activity: AppCompatActivity

    constructor(activity: AppCompatActivity) {
        this.activity = activity
    }


    override fun goBack() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBackPressed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}