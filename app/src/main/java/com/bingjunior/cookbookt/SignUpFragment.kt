package com.bingjunior.cookbookt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.bingjunior.cookbookt.databinding.FragmentSignUpBinding
import com.google.android.material.textfield.TextInputEditText

private const val EMAIL_CONTENTS = "EmailContent"
private const val PWD_CONTENTS = "PwdContent"
private const val USERNAME_CONTENTS = "UsenameContent"
private const val CONFIRMPWD_CONTENTS = "ConfirmPwdContent"

class SignUpFragment : Fragment() {
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon : NavController

    val email: TextInputEditText = binding.email
    val password: TextInputEditText = binding.password
    val confirmPassword: TextInputEditText = binding.confirmPassword
    val username: TextInputEditText = binding.userName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.clickSignIn.setOnClickListener {
            navCon.navigate(R.id.action_signUpFragment_to_signInFragment)
        }
        binding.signUpButton.setOnClickListener {
            navCon.navigate(R.id.action_signUpFragment_to_listOfTopicsFragment)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        //saving email and password
        outState.putString(EMAIL_CONTENTS, email.text.toString())
        outState.putString(PWD_CONTENTS, password.text.toString())
        outState.putString(CONFIRMPWD_CONTENTS, confirmPassword.text.toString())
        outState.putString(USERNAME_CONTENTS, username.text.toString())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        //restoring email and password
        val savedEmail = savedInstanceState?.getString(EMAIL_CONTENTS,"")
        val savedPwd = savedInstanceState?.getString(PWD_CONTENTS,"")
        val savedConfirmPwd = savedInstanceState?.getString(CONFIRMPWD_CONTENTS,"")
        val savedUsername = savedInstanceState?.getString(USERNAME_CONTENTS,"")
        email.setText(savedEmail)
        password.setText(savedPwd)
        username.setText(savedUsername)
        confirmPassword.setText(savedConfirmPwd)
    }
}