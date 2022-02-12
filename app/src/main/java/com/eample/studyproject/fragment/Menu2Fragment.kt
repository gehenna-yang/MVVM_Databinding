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
import com.eample.studyproject.databinding.FragmentMenu2Binding
import com.eample.studyproject.viewmodel.Menu2ViewModel

class Menu2Fragment : Fragment() {

    lateinit var menu2VM: Menu2ViewModel
    lateinit var binding: FragmentMenu2Binding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        menu2VM = ViewModelProvider(this).get(Menu2ViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu2, container, false)

        menu2VM.getText().observe(viewLifecycleOwner, Observer { binding.textMenu2.text = it })

        return binding.root
    }
}