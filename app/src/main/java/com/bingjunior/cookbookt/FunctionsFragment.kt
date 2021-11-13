package com.bingjunior.cookbookt

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.bingjunior.cookbookt.databinding.FragmentFunctionsBinding

class FunctionsFragment : Fragment() {

    private var _binding: FragmentFunctionsBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFunctionsBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //share topic button
        binding.shareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val resourceUrl = "https://typealias.com/start/kotlin-functions/"
            intent.putExtra(Intent.EXTRA_TEXT, "$resourceUrl")
            val chooser = Intent.createChooser(intent, "Share this topic using: ")
            startActivity(chooser)
        }

        //sign out button
        binding.signOutButton.setOnClickListener {
            navCon.navigate(R.id.action_functionsFragment_to_signInFragment)
        }
    }
}

