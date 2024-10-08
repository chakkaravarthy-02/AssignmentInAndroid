package com.example.assignment6.put

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.assignment6.database.DetailsDatabase
import com.example.databaseapplication.R
import com.example.databaseapplication.databinding.FragmentPutBinding

class PutFragment : Fragment() {

    private lateinit var binding: FragmentPutBinding
    private lateinit var putFragmentViewModel: PutFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_put, container, false)

        val detailsDao = DetailsDatabase.getInstance(requireContext()).detailsDatabaseDao
        val factory = PutFragmentViewModelFactory(detailsDao)

        putFragmentViewModel = ViewModelProvider(this, factory)[PutFragmentViewModel::class.java]

        putFragmentViewModel.lastDetails.observe(viewLifecycleOwner, Observer { details ->
            details?.let {
                binding.textView1.text = it.personName
                binding.textView2.text = it.fatherName
                binding.textView3.text = it.motherName
                binding.textView4.text = it.phoneNumber
                binding.textView5.text = it.emailId
            }
        })

        binding.buttonPut.setOnClickListener{
            this.findNavController().navigate(PutFragmentDirections.actionPutFragmentToGetFragment())
        }
        return binding.root
    }
}