package com.example.assignment9.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assignment9.R
import com.example.assignment9.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {

    private lateinit var binding: FragmentOverviewBinding
    private lateinit var adapter: FlagGridAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false)

        binding.lifecycleOwner = this

        val viewModel = ViewModelProvider(this)[OverviewViewModel::class.java]
        binding.viewModel = viewModel

        binding.flagGrid.layoutManager = GridLayoutManager(context, 2)

        viewModel.properties.observe(viewLifecycleOwner) { country ->
            adapter = FlagGridAdapter(country)
            binding.flagGrid.adapter = adapter
        }


        return binding.root
    }
}