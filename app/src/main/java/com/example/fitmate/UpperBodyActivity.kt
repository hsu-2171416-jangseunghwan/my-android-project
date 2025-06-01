package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class UpperBodyActivity : AppCompatActivity() {
    private var selectedExercise = ""
    private var count = 0
    private val caloriePerRep = 0.5 // 예시값: 푸시업 1회당 0.5kcal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upper_body)

        val infoText = findViewById<TextView>(R.id.exerciseInfo)
        val pushupBtn = findViewById<Button>(R.id.pushupButton)
        val shoulderBtn = findViewById<Button>(R.id.shoulderButton)
        val curlBtn = findViewById<Button>(R.id.curlButton)
        val countText = findViewById<TextView>(R.id.countText)
        val countBtn = findViewById<Button>(R.id.countButton)
        val finishBtn = findViewById<Button>(R.id.finishButton)

        pushupBtn.setOnClickListener {
            selectedExercise = "푸시업"
            infoText.text = "선택 운동: 푸시업\n설명: 가슴, 어깨, 팔 강화"
        }

        shoulderBtn.setOnClickListener {
            selectedExercise = "숄더 프레스"
            infoText.text = "선택 운동: 숄더 프레스\n설명: 어깨 근육 강화"
        }

        curlBtn.setOnClickListener {
            selectedExercise = "덤벨 컬"
            infoText.text = "선택 운동: 덤벨 컬\n설명: 이두근 강화"
        }

        countBtn.setOnClickListener {
            count++
            countText.text = "횟수: $count 회"
        }

        finishBtn.setOnClickListener {
            val totalCal = count * caloriePerRep
            Toast.makeText(this, "소모 칼로리: %.1f kcal".format(totalCal), Toast.LENGTH_SHORT).show()

            // TODO: 전역 변수나 Intent로 4페이지에 전달 가능
            val intent = Intent(this, FinishActivity::class.java)
            intent.putExtra("CALORIES", totalCal)
            startActivity(intent)
        }
    }
}