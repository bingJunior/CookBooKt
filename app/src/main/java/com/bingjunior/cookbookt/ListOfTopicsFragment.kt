package com.bingjunior.cookbookt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.bingjunior.cookbookt.databinding.FragmentListOfTopicsBinding
import kotlin.system.measureTimeMillis

class ListOfTopicsFragment : Fragment() {

    private var _binding: FragmentListOfTopicsBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon : NavController

 override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View {
    // Inflate the layout for this fragment
    _binding = FragmentListOfTopicsBinding.inflate(inflater, container, false)
    navCon = NavHostFragment.findNavController(this)
     val listView = binding.topicsListView
     val list = mutableListOf<Model>()

     list.add(Model("Variables", R.drawable.v))
     list.add(Model("Expressions", R.drawable.e))
     list.add(Model("Types", R.drawable.t))
     list.add(Model("Functions", R.drawable.f))
     list.add(Model("Conditionals", R.drawable.c))

     listView.adapter = activity?.let { Adapter(it, R.layout.row, list) }
     listView.isClickable = true

     listView.setOnItemClickListener { _, _, position, _ ->
         if (position == 0) {
             Toast.makeText(activity, "You clicked on Variables", Toast.LENGTH_SHORT).show()
             navCon.navigate(R.id.action_listOfTopicsFragment_to_variablesFragment)
         }
         if (position == 1) {
             Toast.makeText(activity, "You clicked on Expressions", Toast.LENGTH_SHORT).show()
             navCon.navigate(R.id.action_listOfTopicsFragment_to_expressionsFragment)
         }
         if (position == 2) {
             Toast.makeText(activity, "You clicked on Types", Toast.LENGTH_SHORT).show()
             navCon.navigate(R.id.action_listOfTopicsFragment_to_typesFragment)
         }
         if (position == 3) {
             Toast.makeText(activity, "You clicked on Functions", Toast.LENGTH_SHORT).show()
             navCon.navigate(R.id.action_listOfTopicsFragment_to_functionsFragment)
         }
         if (position == 4) {
             Toast.makeText(activity, "You clicked on Conditionals", Toast.LENGTH_SHORT).show()
             navCon.navigate(R.id.action_listOfTopicsFragment_to_conditionalsFragment)
         }
     }

     return binding.root
}

}