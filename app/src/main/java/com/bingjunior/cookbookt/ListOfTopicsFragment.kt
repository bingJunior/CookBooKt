package com.bingjunior.cookbookt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.bingjunior.cookbookt.databinding.FragmentListOfTopicsBinding

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

     listView.adapter = Adapter(this, R.layout.row, list)

     return binding.root

    /* listView.setOnItemClickListener{parent:AdapterView<*>, view:View, position:Int, id:Long ->
         if (position == 0) {
             Toast.makeText(this@ListOfTopicsFragment, "You clicked on Variables", Toast.LENGTH_LONG).show()
         }
     }


}

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.clickSignIn.setOnClickListener {
        navCon.navigate(R.id.action_signUpFragment_to_signInFragment)
    }
    binding.signUpButton.setOnClickListener {
        navCon.navigate(R.id.action_signUpFragment_to_listOfTopicsFragment)
    }
*/
}
}