package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StrengthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strength)

        val upperButton = findViewById<Button>(R.id.upperButton)
        val lowerButton = findViewById<Button>(R.id.lowerButton)

        upperButton.setOnClickListener {
            startActivity(Intent(this, UpperBodyActivity::class.java))
        }

        lowerButton.setOnClickListener {
            //startActivity(Intent(this, LowerBodyActivity::class.java))
        }
    }
}