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
import com.eample.studyproject.databinding.FragmentMenu1Binding
import com.eample.studyproject.viewmodel.Menu1ViewModel

class Menu1Fragment : Fragment() {

    lateinit var menu1VM: Menu1ViewModel
    lateinit var binding: FragmentMenu1Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        menu1VM = ViewModelProvider(this).get(Menu1ViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu1, container, false)

        menu1VM.getText().observe(viewLifecycleOwner, Observer {
            binding.textMenu1.text = it
        })

        return binding.root
    }
}