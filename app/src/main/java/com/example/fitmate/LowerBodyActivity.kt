package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LowerBodyActivity : AppCompatActivity() {
    private var selectedExercise = ""
    private var count = 0
    private val caloriePerRep = 0.5 // 예시값

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lower_body)

        val infoText = findViewById<TextView>(R.id.exerciseInfo)
        val squatBtn = findViewById<Button>(R.id.squatButton)
        val lungeBtn = findViewById<Button>(R.id.lungeButton)
        val bridgeBtn = findViewById<Button>(R.id.bridgeButton)
        val countText = findViewById<TextView>(R.id.countText)
        val countBtn = findViewById<Button>(R.id.countButton)
        val finishBtn = findViewById<Button>(R.id.finishButton)

        squatBtn.setOnClickListener {
            selectedExercise = "스쿼트"
            infoText.text = "선택 운동: 스쿼트\n설명: 허벅지, 엉덩이 강화"
        }

        lungeBtn.setOnClickListener {
            selectedExercise = "런지"
            infoText.text = "선택 운동: 런지\n설명: 하체 근육과 균형 감각 강화"
        }

        bridgeBtn.setOnClickListener {
            selectedExercise = "힙 브릿지"
            infoText.text = "선택 운동: 힙 브릿지\n설명: 엉덩이 및 허리 강화"
        }

        countBtn.setOnClickListener {
            count++
            countText.text = "횟수: $count 회"
        }

        finishBtn.setOnClickListener {
            val totalCal = count * caloriePerRep
            Toast.makeText(this, "소모 칼로리: %.1f kcal".format(totalCal), Toast.LENGTH_SHORT).show()

            val intent = Intent(this, FinishActivity::class.java)
            intent.putExtra("CALORIES", totalCal)
            startActivity(intent)
        }
    }
}