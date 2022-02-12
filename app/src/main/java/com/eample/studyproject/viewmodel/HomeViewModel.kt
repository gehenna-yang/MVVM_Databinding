package com.eample.studyproject.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel() : ViewModel() {
    private lateinit var text : MutableLiveData<String>
    private var value: Int = 0

    init {
        value = 0
        text = MutableLiveData()
        text.value = "Home"
    }

    fun getText(): LiveData<String> { return text }

    fun up(){
        text.value = value++.toString()
        Log.e("UP","UP "+value)
    }

    fun down(){
        text.value = value--.toString()
        Log.e("DOWN","DOWN "+value)
    }
}