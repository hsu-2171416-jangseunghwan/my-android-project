package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val startButton: Button = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            // 메인 정보 입력 페이지로 이동
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // IntroActivity는 종료
        }
    }
}