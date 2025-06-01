package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinishActivity : AppCompatActivity() {

    private lateinit var caloriesTextView: TextView
    private lateinit var retryButton: Button
    private lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        caloriesTextView = findViewById(R.id.caloriesTextView)
        retryButton = findViewById(R.id.retryButton)
        exitButton = findViewById(R.id.exitButton)

        // 🔸 전달된 칼로리 값 가져오기
        val calories = intent.getDoubleExtra("CALORIES", 0.0)

        // 🔸 전역 칼로리 누적 (CalorieManager 사용 중일 경우)
        CalorieManager.addCalories(calories)

        // 🔸 총 칼로리 출력
        val totalCalories = CalorieManager.totalCalories
        caloriesTextView.text = "오늘 소모한 총 칼로리: %.1f kcal".format(totalCalories)

        // 🔸 다시 운동하기 버튼
        retryButton.setOnClickListener {
            val intent = Intent(this, SelectExerciseActivity::class.java)
            startActivity(intent)
            finish()
        }

        // 🔸 종료 버튼
        exitButton.setOnClickListener {
            val intent = Intent(this, SummaryActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}