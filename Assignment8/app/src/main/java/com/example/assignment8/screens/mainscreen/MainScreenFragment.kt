package com.example.assignment8.screens.mainscreen

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
import com.example.assignment8.databinding.FragmentMainScreenBinding
import com.example.assignment8.network.ImageApiStatus
import kotlin.properties.Delegates
import kotlin.random.Random

class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding
    private lateinit var mainViewModel: MainScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false)

        val factory = MainViewModelFactory()
        mainViewModel = ViewModelProvider(this,factory)[MainScreenViewModel::class.java]

        binding.lifecycleOwner = this
        binding.mainViewModel = mainViewModel

        mainViewModel.navigateToImage.observe(viewLifecycleOwner, Observer {
            if(it) {
                val rand = Random.nextInt(25)
                findNavController().navigate(MainScreenFragmentDirections.actionMainScreenFragmentToImageFragment(mainViewModel.characterBundle[rand]))
                mainViewModel.doneNavigating()
            }
        })

        mainViewModel.response.observe(viewLifecycleOwner, Observer {
            if(it!=null) {
                binding.jsonText.text = it.toString()
                mainViewModel.setCharacterDetail(it)
                binding.toTextButton.visibility = View.GONE
                binding.toImageButton.visibility = View.VISIBLE
            }
        })

        mainViewModel.status.observe(viewLifecycleOwner, Observer {
            when(it){
                ImageApiStatus.LOADING -> binding.scroll.setBackgroundResource(R.drawable.loading_animation)
                ImageApiStatus.DONE -> binding.scroll.setBackgroundResource(0)
                ImageApiStatus.ERROR -> binding.scroll.setBackgroundResource(R.drawable.ic_connection_error)
            }
        })


        return binding.root
    }
}