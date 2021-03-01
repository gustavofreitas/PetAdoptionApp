package com.example.androiddevchallenge.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    private val _pets: MutableLiveData<List<String>> = MutableLiveData(listOf())
    val pets: LiveData<List<String>> = _pets

    init {
        getPetList()
    }

    private fun getPetList() {
        _pets.value = listOf("Snow", "Sofia", "Clara", "Milie", "Cleo", "Pretinha", "Loirinho", "Frajola")
    }
}