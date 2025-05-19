package com.example.myhistorycards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import java.time.temporal.Temporal

class Quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val true_butt = findViewById<Button>(R.id.true_butt)//True button listener
        val false_butt = findViewById<Button>(R.id.false_butt)//False button listener
        val next_butt = findViewById<Button>(R.id.next_butt)//Next question button listener
        var tvQuestions = findViewById<TextView>(R.id.tvQuestions)//Textview id
        val score_butt = findViewById<Button>(R.id.score_butt)//score button listener
        var score = 0
        var currentQuestionIndex = 0

        val questions = arrayOf(
            "Christiaan Barnard performed the first heart transplant",
            "The Titanic was sank by a polar bear.",
            "The Boer Wars were fought between the British Empire and the Zulu Kingdom",
            "World War I began in 1914",
            "The first person to walk on the moon was Neil Armstrong"
        )

        val answers = arrayOf(
            "True",
            "False",
            "False",
            "True",
            "True"
        )

        fun displayQuestion() {
    if (currentQuestionIndex < questions.size) {
        tvQuestions.text = questions[currentQuestionIndex]
        true_butt.isEnabled = true // Enable for the new question
        false_butt.isEnabled = true // Enable for the new question
        next_butt.isEnabled = false // Disable next until an answer is given (optional, but good practice)
    } else {
        // Quiz is over
        tvQuestions.text = "Quiz Finished! Click View Score to see your results."
        true_butt.isEnabled = false
        false_butt.isEnabled = false
        next_butt.isEnabled = false
        score_butt.isEnabled = true // Make sure score button is enabled
    }
}

// Initial display
displayQuestion()

next_butt.setOnClickListener {
    currentQuestionIndex++ // Move to the next question index
    displayQuestion()      // Display the new current question
}

true_butt.setOnClickListener {
    if (currentQuestionIndex < questions.size) { //
        if (answers[currentQuestionIndex] == "True") {
            score++

        } else {

        }
        // Prevent answering the same question multiple times before moving to next
        true_butt.isEnabled = false
        false_butt.isEnabled = false
        if (currentQuestionIndex < questions.size -1) {
             next_butt.isEnabled = true
        } else { // Last question answered
            tvQuestions.text = "Quiz Finished! Click Score to see your results."
            next_butt.isEnabled = false
            score_butt.isEnabled = true
        }
    }
}

false_butt.setOnClickListener { // You'll need a similar listener for the false button
    if (currentQuestionIndex < questions.size) {
        if (answers[currentQuestionIndex] == "False") {
            score++

        } else {

        }
        true_butt.isEnabled = false
        false_butt.isEnabled = false
        if (currentQuestionIndex < questions.size -1) {
             next_butt.isEnabled = true
        } else {
            tvQuestions.text = "Quiz Finished! Click Score to see your results."
            next_butt.isEnabled = false
            score_butt.isEnabled = true
        }
    }
}

score_butt.setOnClickListener {
    val intent = Intent(this, Scorecard::class.java)
    intent.putExtra("scoreOnNext", score)
    intent.putExtra("totalQuestions", questions.size) //
    startActivity(intent)

}




    }
}