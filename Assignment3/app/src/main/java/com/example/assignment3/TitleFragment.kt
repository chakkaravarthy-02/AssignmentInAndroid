package com.example.assignment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.assignment3.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_title, container, false
        )

        binding.button.setOnClickListener { view: View ->
            val numberString: String = binding.editTextPhone.text.toString()
            if (numberString[0] == '7' && numberString[9] == '7') {
                view.findNavController().navigate(
                    TitleFragmentDirections.actionTitleFragmentToShowWonDetailsFragment(
                        binding.editTextText.text.toString(),
                        binding.editTextTextEmailAddress.text.toString()
                    )
                )
            } else {
                view.findNavController().navigate(
                    TitleFragmentDirections.actionTitleFragmentToShowLoseDetailsFragment(
                        binding.editTextText.text.toString(),
                        binding.editTextTextEmailAddress.text.toString()
                    )
                )
            }
        }

        return binding.root
    }
}