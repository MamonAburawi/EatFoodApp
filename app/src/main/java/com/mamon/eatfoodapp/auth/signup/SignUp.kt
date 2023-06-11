package com.mamon.eatfoodapp.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mamon.eatfoodapp.R
import com.mamon.eatfoodapp.databinding.SignUpBinding

class SignUp : Fragment() {

    private lateinit var binding: SignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = SignUpBinding.inflate(inflater,container,false)


        setViews()

        return binding.root
    }

    private fun setViews() {
        binding.apply{

            btnSignUp.setOnClickListener {
                navigateToHome()
            }

            btnLogin.setOnClickListener {
                navigationToLogin()
            }
        }
    }


    private fun navigationToLogin(){
        findNavController().navigate(R.id.action_signUp_to_login)
    }

    private fun navigateToHome(){
        findNavController().navigate(R.id.action_signUp_to_home)
    }




}