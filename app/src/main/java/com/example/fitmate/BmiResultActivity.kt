package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BmiResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_result)

        val bmi = intent.getDoubleExtra("BMI_VALUE", 0.0)
        val bmiTextView = findViewById<TextView>(R.id.bmiTextView)
        val categoryTextView = findViewById<TextView>(R.id.categoryTextView)
        val recommendButton = findViewById<Button>(R.id.recommendButton)
        val otherButton = findViewById<Button>(R.id.otherButton)

        // BMI 상태 분류
        val category: String
        var recommendType: String
        var otherType: String

        when {
            bmi < 18.5 -> {
                category = "저체중"
                recommendType = "근력"
                otherType = "유산소"
            }
            bmi < 25 -> {
                category = "정상 체중"
                // 사용자가 선택할 수 있게 버튼 텍스트만 바꿔두고 둘 다 가능
                recommendType = "유산소"
                otherType = "근력"
            }
            else -> {
                category = "과체중"
                recommendType = "유산소"
                otherType = "근력"
            }
        }

        bmiTextView.text = "당신의 BMI: %.2f".format(bmi)
        categoryTextView.text = "분류: $category"

        recommendButton.text = "$recommendType 운동 하러 가기"
        otherButton.text = "$otherType 운동 해볼래요"

        // 운동 페이지 이동 인텐트 생성 함수
        fun moveTo(type: String) {
            val intent = when (type) {
                "유산소" -> Intent(this, CardioActivity::class.java)
                "근력" -> Intent(this, StrengthActivity::class.java)
                else -> return
            }
            intent.putExtra("BMI_VALUE", bmi)
            startActivity(intent)
        }

        // 버튼 클릭 이벤트
        recommendButton.setOnClickListener { moveTo(recommendType) }
        otherButton.setOnClickListener { moveTo(otherType) }
    }
}