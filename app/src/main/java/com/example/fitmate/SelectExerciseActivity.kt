package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelectExerciseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_exercise)

        val cardioButton = findViewById<Button>(R.id.cardioButton)
        val strengthButton = findViewById<Button>(R.id.strengthButton)

        cardioButton.setOnClickListener {
            val intent = Intent(this, CardioActivity::class.java)
            startActivity(intent)
            finish()
        }

        strengthButton.setOnClickListener {
            val intent = Intent(this, StrengthActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}