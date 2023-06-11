package com.mamon.eatfoodapp.auth

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mamon.eatfoodapp.R
import com.mamon.eatfoodapp.databinding.SplashBinding

class Splash : Fragment() {

    private lateinit var binding: SplashBinding
    companion object{
        const val TIME_INTERVAL = 1000L
        const val THREE_SECOND = 3000L
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = SplashBinding.inflate(inflater,container,false)


        setSplashTimer()


        return binding.root
    }



    private fun setSplashTimer() {
        object : CountDownTimer(TIME_INTERVAL, THREE_SECOND) {
            override fun onTick(millisUntilFinished: Long) {}

            override fun onFinish() {
                findNavController().navigate(R.id.action_splash_to_login)
            }
        }.start()
    }


}