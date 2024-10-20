package com.example.bmiexersice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {

    private val _heightInput = MutableLiveData("")
    private val _weightInput = MutableLiveData("")

    private val _bmiResult = MutableLiveData(0.0)

    val heightInput: LiveData<String> = _heightInput
    val weightInput: LiveData<String> = _weightInput
    val bmiResult: LiveData<Double> = _bmiResult

    fun updateHeight(height: String) {
        _heightInput.value = height.replace(',', '.')
        calculateBmi()
    }

    fun updateWeight(weight: String) {
        _weightInput.value = weight.replace(',', '.')
        calculateBmi()
    }

    private fun calculateBmi() {
        val height = _heightInput.value?.toDoubleOrNull() ?: 0.0
        val weight = _weightInput.value?.toDoubleOrNull() ?: 0.0

        _bmiResult.value = if (height > 0 && weight > 0) {
            weight / (height * height)
        } else {
            0.0
        }
    }
}
