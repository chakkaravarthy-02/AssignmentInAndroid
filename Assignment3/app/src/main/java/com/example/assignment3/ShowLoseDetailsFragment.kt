package com.example.assignment3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.assignment3.databinding.FragmentShowLoseDetailsBinding
import com.example.assignment3.databinding.FragmentTitleBinding

class ShowLoseDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShowLoseDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_show_lose_details, container, false
        )
        var args = ShowWonDetailsFragmentArgs.fromBundle(requireArguments())
        Log.i("ShowLoseDetailsFragment", args.name)
        binding.nameText.text = args.name
        binding.emailText.text = args.email


        return binding.root
    }
}