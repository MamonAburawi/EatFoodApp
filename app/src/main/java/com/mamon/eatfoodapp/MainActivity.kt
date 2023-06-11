package com.mamon.eatfoodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.mamon.eatfoodapp.databinding.ActivityMainBinding
import com.mamon.eatfoodapp.utils.setColorStatusBar

class MainActivity : AppCompatActivity() {

    private lateinit var navFragment: NavHostFragment
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        setUpNav()

    }


    private fun setUpNav() {
        navFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.signUp -> {setColorStatusBar(R.color.red)}
                R.id.login ->{setColorStatusBar(R.color.red)}
                R.id.home -> {setColorStatusBar(R.color.red)}
                else -> setColorStatusBar(R.color.red_light)
            }
        }
    }




}