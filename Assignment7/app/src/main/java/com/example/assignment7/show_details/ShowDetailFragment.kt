package com.example.assignment7.show_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment7.R
import com.example.assignment7.database.ColorItem
import com.example.assignment7.databinding.FragmentShowDetailBinding
import com.example.assignment7.list.ListContainFragment

class ShowDetailFragment : Fragment() {
    private lateinit var binding: FragmentShowDetailBinding
    private lateinit var adapter: ColorAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_show_detail, container, false)
        adapter = ColorAdapter(ListContainFragment.colorList)
        binding.colorList.layoutManager = LinearLayoutManager(requireContext())

        binding.colorList.adapter = adapter
        binding.lifecycleOwner = this
        binding.showFragment = this

        return binding.root
    }
    fun navigateToHome(){
        findNavController().navigate(ShowDetailFragmentDirections.actionShowDetailFragmentToListContainFragment())
    }
}