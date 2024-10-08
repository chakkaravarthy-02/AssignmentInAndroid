package com.example.assignment8.screens.imagescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.assignment8.R
import com.example.assignment8.databinding.FragmentImageBinding

class ImageFragment : Fragment() {

    private lateinit var binding: FragmentImageBinding
    private lateinit var imageViewModel: ImageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image,container,false)
        val app = requireNotNull(activity).application
        val imageArgs = ImageFragmentArgs.fromBundle(requireArguments()).CharacterProperty

        val factory = ImageViewModelFactory(imageArgs, app)
        imageViewModel = ViewModelProvider(this,factory)[ImageViewModel::class.java]

        binding.lifecycleOwner = this
        binding.imageViewModel = imageViewModel

        imageViewModel.navigateToMain.observe(viewLifecycleOwner, Observer {
            if(it){
                findNavController().navigate(ImageFragmentDirections.actionImageFragmentToMainScreenFragment())
                imageViewModel.doneNavigating()
            }
        })

        return binding.root
    }
}