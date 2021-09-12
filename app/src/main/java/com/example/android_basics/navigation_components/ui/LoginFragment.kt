package com.example.android_basics.navigation_components.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android_basics.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cnf_btn.setOnClickListener {
            val action =
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username.text.toString())
            findNavController().navigate(action)
        }
    }
}