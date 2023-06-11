package com.mamon.eatfoodapp.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mamon.eatfoodapp.R
import com.mamon.eatfoodapp.databinding.LoginBinding

class Login : Fragment() {

    private lateinit var binding: LoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = LoginBinding.inflate(inflater,container,false)


        setViews()

        return binding.root
    }

    private fun setViews() {
        binding.apply {

            /** button sign up **/
            btnSignUp.setOnClickListener {
                navigateToSignUp()
            }

            /** button login **/
            btnLogin.setOnClickListener {
                navigationToHome()
            }

        }
    }


    private fun navigateToSignUp(){
        findNavController().navigate(R.id.action_login_to_signUp)
    }

    private fun navigationToHome(){
        findNavController().navigate(R.id.action_login_to_home)
    }

}