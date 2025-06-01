package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CardioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cardio)

        val cycleButton = findViewById<Button>(R.id.cycleButton)
        val walkButton = findViewById<Button>(R.id.walkButton)

        cycleButton.setOnClickListener {
            val intent = Intent(this, CardioDetailActivity::class.java)
            intent.putExtra("EXERCISE_TYPE", "사이클")
            startActivity(intent)
        }

        walkButton.setOnClickListener {
            val intent = Intent(this, CardioDetailActivity::class.java)
            intent.putExtra("EXERCISE_TYPE", "걷기")
            startActivity(intent)
        }
    }
}
