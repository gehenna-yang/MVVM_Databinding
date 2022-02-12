package com.eample.studyproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eample.studyproject.R
import com.eample.studyproject.databinding.FragmentHomeBinding
import com.eample.studyproject.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    lateinit var homeVM: HomeViewModel
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        homeVM = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.homevm = homeVM
        binding.lifecycleOwner = this

        homeVM.getText().observe(viewLifecycleOwner, Observer {
            binding.texthome.text = it
        })

        return binding.root
    }
}