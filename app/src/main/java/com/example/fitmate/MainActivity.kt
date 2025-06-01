package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var ageRadioGroup: RadioGroup
    private lateinit var heightEditText: EditText
    private lateinit var weightEditText: EditText
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        genderRadioGroup = findViewById(R.id.genderRadioGroup)
        ageRadioGroup = findViewById(R.id.ageRadioGroup)
        heightEditText = findViewById(R.id.heightEditText)
        weightEditText = findViewById(R.id.weightEditText)
        nextButton = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            val selectedGenderId = genderRadioGroup.checkedRadioButtonId
            val selectedAgeId = ageRadioGroup.checkedRadioButtonId

            if (selectedGenderId == -1) {
                Toast.makeText(this, "성별을 선택하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (selectedAgeId == -1) {
                Toast.makeText(this, "나이대를 선택하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val heightStr = heightEditText.text.toString()
            val weightStr = weightEditText.text.toString()

            if (heightStr.isEmpty() || weightStr.isEmpty()) {
                Toast.makeText(this, "키와 몸무게를 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height = heightStr.toDoubleOrNull()
            val weight = weightStr.toDoubleOrNull()

            if (height == null || weight == null) {
                Toast.makeText(this, "키와 몸무게는 숫자로 입력해야 합니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // BMI 계산 (키는 cm → m 변환)
            val heightInMeters = height / 100.0
            val bmi = weight / (heightInMeters * heightInMeters)

            // 다음 액티비티로 bmi 값 전달
            val intent = Intent(this, BmiResultActivity::class.java)
            intent.putExtra("BMI_VALUE", bmi)
            startActivity(intent)
        }
    }
}