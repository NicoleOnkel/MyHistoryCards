package com.example.myhistorycards

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewTest : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_test)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val r_exit_butt = findViewById<Button>(R.id.r_exit_butt)//exit button

        val allContentTextView = findViewById<TextView>(R.id.allContentTextView)

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


        val contentBuilder = StringBuilder()

        for (i in questions.indices) {
            contentBuilder.append("Q: ${questions[i]}\n") // \n for a new line
            contentBuilder.append("A: ${answers[i]}\n\n") // Extra new line for spacing
        }

        allContentTextView.text = contentBuilder.toString()





        r_exit_butt.setOnClickListener {
            finishAffinity()
        }





    }
}