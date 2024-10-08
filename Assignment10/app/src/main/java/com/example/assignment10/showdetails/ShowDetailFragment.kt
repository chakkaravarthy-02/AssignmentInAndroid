package com.example.assignment10.showdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.assignment10.R
import com.example.assignment10.databinding.FragmentShowDetailBinding
import com.example.assignment10.repository.GamesRepository

class ShowDetailFragment : Fragment() {

    private lateinit var binding: FragmentShowDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_show_detail,container,false)
        val application = requireNotNull(activity).application
        val factory = ShowDetailViewModelFactory(application)
        val viewModel = ViewModelProvider(this,factory)[ShowDetailViewModel::class.java]

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.response.observe(viewLifecycleOwner, Observer {
            if(it!=null) {
                val adapter = ShowDetailAdapter(it)
                binding.detailList.adapter = adapter
            }
        })

        return binding.root
    }
}