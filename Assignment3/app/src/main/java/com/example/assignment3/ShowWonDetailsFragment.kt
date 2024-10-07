package com.example.assignment3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.assignment3.databinding.FragmentShowDetailsBinding
import com.example.assignment3.databinding.FragmentShowLoseDetailsBinding

class ShowWonDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShowDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_show_details, container, false
        )
        var args = ShowWonDetailsFragmentArgs.fromBundle(requireArguments())
        binding.nameText.text = args.name
        binding.emailText.text = args.email

        return binding.root
    }
}