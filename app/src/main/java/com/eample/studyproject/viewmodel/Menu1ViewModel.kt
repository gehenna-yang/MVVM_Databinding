package com.eample.studyproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Menu1ViewModel : ViewModel() {
    private lateinit var text : MutableLiveData<String>

    init {
        text = MutableLiveData()
        text.value = "Menu1"
    }

    fun getText(): LiveData<String> { return text }
}