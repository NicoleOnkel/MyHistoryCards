package com.example.myhistorycards

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Scorecard : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_scorecard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Retrieve the score and total questions from the Intent
        val score = intent.getIntExtra("scoreOnNext", 0)
        val exit_butt = findViewById<Button>(R.id.exit_butt)
        // Find your TextViews
        val actualScoreTextView = findViewById<TextView>(R.id.actualScoreTextView) // TextView for "Your Score: X / Y"
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)


        val scoreTextView = findViewById<TextView>(R.id.feedback)


        // Display the score

        actualScoreTextView.text = "Your Score: $score / $totalQuestions"

        // display feedback based on the score
        val percentage = if (totalQuestions > 0) {
            (score.toDouble() / totalQuestions.toDouble()) * 100
        } else {
            0.0
        }

        scoreTextView.text = when {
            percentage >= 90 -> "Excellent!"
            percentage >= 70 -> "Great Job!"
            percentage >= 50 -> "Good Effort!"
            else -> "Keep Practicing!"
        }


       val review_butt = findViewById<Button>(R.id.review_butt)

        review_butt.setOnClickListener {
            val intent = Intent(this, ReviewTest::class.java)
            startActivity(intent)}
        //Review button



        //Exit Button

        exit_butt.setOnClickListener {
            finishAffinity()
        }







    }
}