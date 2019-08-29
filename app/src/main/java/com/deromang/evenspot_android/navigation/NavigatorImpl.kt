package com.deromang.evenspot_android.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.deromang.evenspot_android.R
import com.deromang.evenspot_android.ui.activity.MainActivity
import com.deromang.evenspot_android.ui.main.MainFragment
import com.deromang.presentation.navigation.Navigator

class NavigatorImpl : Navigator {

    val CONTAINER_ID = R.id.container

    private var activity: AppCompatActivity

    constructor(activity: AppCompatActivity) {
        this.activity = activity
    }

    override fun goBack() {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
    }

    override fun onBackPressed() {
        activity.getSupportFragmentManager().popBackStackImmediate()
    }

    override fun goToMainFragment() {
        activity.supportFragmentManager.popBackStackImmediate(
            null,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
        replaceFragment(MainFragment().newInstance(), false)
    }

    private fun replaceFragment(fragment: Fragment, addToBack: Boolean) {
        val fragmentManager = activity.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()


        if (addToBack) {
            fragmentTransaction.addToBackStack(null)
        }

        fragmentTransaction.replace(CONTAINER_ID, fragment)
        fragmentTransaction.commit()
    }

}