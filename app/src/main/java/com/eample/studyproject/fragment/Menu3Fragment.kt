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
import com.eample.studyproject.databinding.FragmentMenu3Binding
import com.eample.studyproject.viewmodel.Menu3ViewModel

class Menu3Fragment : Fragment() {

    lateinit var menu3VM: Menu3ViewModel
    lateinit var binding: FragmentMenu3Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        menu3VM = ViewModelProvider(this).get(Menu3ViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu3, container, false)

        menu3VM.getText().observe(viewLifecycleOwner, Observer { binding.textMenu3.text = it })

        return binding.root
    }
}