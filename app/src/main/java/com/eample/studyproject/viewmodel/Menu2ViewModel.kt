package com.eample.studyproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Menu2ViewModel : ViewModel() {
    private lateinit var text : MutableLiveData<String>

    init {
        text = MutableLiveData()
        text.value = "Menu2"
    }

    fun getText(): LiveData<String> { return text }
}