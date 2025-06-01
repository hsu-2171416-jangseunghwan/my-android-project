package com.example.fitmate

object CalorieManager {
    var totalCalories: Double = 0.0

    fun addCalories(amount: Double) {
        totalCalories += amount
    }

    fun reset() {
        totalCalories = 0.0
    }
}