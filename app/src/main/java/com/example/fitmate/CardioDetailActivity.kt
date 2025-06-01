package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CardioDetailActivity : AppCompatActivity() {

    private lateinit var timeInput: EditText
    private lateinit var startButton: Button
    private lateinit var timerTextView: TextView
    private lateinit var endButton: Button

    private var timer: CountDownTimer? = null
    private var totalMinutes: Int = 0
    private var caloriesBurned: Double = 0.0
    private var userWeight: Double = 60.0 // 기본값, 필요시 인텐트로 전달

    // MET 값 예시 (걷기 3.5, 사이클 6.8)
    private var MET: Double = 3.5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardio_detail)

        timeInput = findViewById(R.id.timeInput)
        startButton = findViewById(R.id.startButton)
        timerTextView = findViewById(R.id.timerTextView)
        endButton = findViewById(R.id.endButton)

        // 사용자 체중 받기 (없으면 기본값 유지)
        userWeight = intent.getDoubleExtra("USER_WEIGHT", 60.0)
        MET = intent.getDoubleExtra("MET_VALUE", 3.5) // 운동 종류 따라 전달 가능

        startButton.setOnClickListener {
            val input = timeInput.text.toString()
            if (input.isEmpty()) {
                Toast.makeText(this, "시간(분)을 입력하세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            totalMinutes = input.toInt()
            startTimer(totalMinutes)
        }

        endButton.setOnClickListener {
            timer?.cancel()
            finishWorkout()
        }
    }

    private fun startTimer(minutes: Int) {
        val totalMillis = minutes * 60 * 1000L
        timer = object : CountDownTimer(totalMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secs = (millisUntilFinished / 1000) % 60
                val mins = (millisUntilFinished / 1000) / 60
                timerTextView.text = String.format("%02d:%02d", mins, secs)
            }

            override fun onFinish() {
                timerTextView.text = "00:00"
                Toast.makeText(this@CardioDetailActivity, "운동 완료!", Toast.LENGTH_SHORT).show()
                finishWorkout()
            }
        }.start()
    }

    private fun finishWorkout() {
        // 칼로리 계산: MET × 체중 × 시간(시간 단위)
        caloriesBurned = MET * userWeight * (totalMinutes / 60.0)

        // 다음 화면으로 이동
        val intent = Intent(this, FinishActivity::class.java)
        intent.putExtra("CALORIES", caloriesBurned)
        startActivity(intent)
        finish()
    }
}