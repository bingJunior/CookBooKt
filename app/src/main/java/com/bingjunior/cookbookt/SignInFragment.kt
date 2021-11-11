package com.bingjunior.cookbookt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.bingjunior.cookbookt.databinding.FragmentSignInBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

private const val EMAIL_CONTENTS = "EmailContent"
private const val PWD_CONTENTS = "PwdContent"

class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon : NavController

    val email: TextInputEditText = binding.emailInputText
    val password: TextInputEditText = binding.passwordInputText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.clickSignUp.setOnClickListener {
            navCon.navigate(R.id.action_signInFragment_to_signUpFragment)
        }
        binding.signInButton.setOnClickListener {
            navCon.navigate(R.id.action_signInFragment_to_listOfTopicsFragment)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        //saving email and password
        outState.putString(EMAIL_CONTENTS, email.text.toString())
        outState.putString(PWD_CONTENTS, password.text.toString())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        //restoring email and password
        val savedEmail = savedInstanceState?.getString(EMAIL_CONTENTS,"")
        val savedPwd = savedInstanceState?.getString(PWD_CONTENTS,"")
        email.setText(savedEmail)
        password.setText(savedPwd)
    }

}