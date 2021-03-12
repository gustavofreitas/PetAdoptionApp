package com.example.androiddevchallenge.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.entity.Pet
import kotlin.random.Random

class HomeViewModel: ViewModel() {

    private val _pets: MutableLiveData<List<Pet>> = MutableLiveData(listOf())
    val pets: LiveData<List<Pet>> = _pets

    init {
        getPetList()
    }

    private fun getPetList() {
        val sex = listOf(R.string.male, R.string.female)
        _pets.value =
            listOf("Snow", "Sofia", "Clara", "Milie", "Cleo", "Pretinha", "Loirinho", "Frajola")
                .map { Pet(it, sex = sex.indexOf(Random.nextInt(sex.size)), pedigree = "Unknown", color = "black") }
    }
}