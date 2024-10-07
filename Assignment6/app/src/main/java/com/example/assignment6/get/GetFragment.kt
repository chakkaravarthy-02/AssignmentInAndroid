package com.example.assignment6.get

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.assignment6.database.Details
import com.example.assignment6.database.DetailsDatabase
import com.example.databaseapplication.R
import com.example.databaseapplication.databinding.FragmentGetBinding

class GetFragment : Fragment() {
    private lateinit var binding: FragmentGetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_get, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = DetailsDatabase.getInstance(application).detailsDatabaseDao

        val viewModelFactory = GetFragmentViewModelFactory(dataSource)

        val getViewModel =
            ViewModelProvider(this, viewModelFactory)[GetFragmentViewModel::class.java]
        // Inflate the layout for this fragment

        getViewModel.navigateToPutFragment.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                this.findNavController().navigate(
                    GetFragmentDirections.actionGetFragmentToPutFragment()
                )
                getViewModel.doneNavigating()
            }
        })

        binding.button.setOnClickListener {
            val name = binding.textView1.text.toString()
            val father = binding.textView2.text.toString()
            val mother = binding.textView3.text.toString()
            val number = binding.textView4.text.toString()
            val email = binding.textView5.text.toString()

            if (name.isNotEmpty() && father.isNotEmpty() && mother.isNotEmpty() && number.isNotEmpty() && email.isNotEmpty()) {
                val detail = Details(1,name, father, mother, number, email)
                getViewModel.insertDetails(detail)
                    Toast.makeText(requireContext(), "Data saved", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "All fields are required", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        return binding.root
    }
}