package com.example.assignment7.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.assignment7.R
import com.example.assignment7.database.ColorItem
import com.example.assignment7.databinding.FragmentListContainBinding

class ListContainFragment : Fragment() {

    companion object {
        lateinit var colorList: List<ColorItem>
    }

    private lateinit var binding: FragmentListContainBinding
    private lateinit var listViewModel: ListContainFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_list_contain, container, false)

        colorList = listOf(
            ColorItem(1, "Red"),
            ColorItem(2, "blue"),
            ColorItem(3, "green"),
            ColorItem(4, "orange"),
            ColorItem(5, "yellow"),
            ColorItem(6, "purple"),
            ColorItem(7, "white")
        )

        val factory = ListContainFragmentViewModelFactory(colorList)
        listViewModel = ViewModelProvider(this, factory)[ListContainFragmentViewModel::class.java]

        binding.lifecycleOwner = this
        binding.listFragment = this

        listViewModel.colors.observe(viewLifecycleOwner, Observer { colors ->
            binding.text1.text = colors[0].name
            binding.text2.text = colors[1].name
            binding.text3.text = colors[2].name
            binding.text4.text = colors[3].name
            binding.text5.text = colors[4].name
            binding.text6.text = colors[5].name
            binding.text7.text = colors[6].name
        })

        return binding.root
    }

    fun navigateToShow() {
        findNavController().navigate(ListContainFragmentDirections.actionListContainFragmentToShowDetailFragment())
    }
}