package com.example.fitmate

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {

    private lateinit var summaryTextView: TextView
    private lateinit var caloriesTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        summaryTextView = findViewById(R.id.summaryTextView)
        caloriesTextView = findViewById(R.id.caloriesTextView)

        val totalCalories = CalorieManager.totalCalories

        summaryTextView.text = "오늘도 수고하셨습니다!"
        caloriesTextView.text = "총 소모 칼로리: %.1f kcal".format(totalCalories)
    }
}