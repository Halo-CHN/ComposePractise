package com.hehebaba.firstcompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExpandViewModel : ViewModel() {
    private val _expanded = MutableLiveData(false)
    val expanded: LiveData<Boolean> = _expanded
    fun onExpandChange(expanded: Boolean) {
        _expanded.value = expanded
    }
}