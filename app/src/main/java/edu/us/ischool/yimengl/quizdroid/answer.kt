package edu.us.ischool.yimengl.quizdroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.content.Intent

class answer: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val yourAnswer = findViewById<TextView>(R.id.txtYourAnswer)
        val txtYourAnswer = intent.getStringExtra("userAnswer")
        yourAnswer.text = "Your Answer: " + txtYourAnswer

        val correctAnswer = findViewById<TextView>(R.id.txtCorrectAnswer)
        val txtCorrectAnswer = intent.getStringExtra("correctAnswer")
        correctAnswer.text = "Correct Answer: " + txtCorrectAnswer

        val currentScore = findViewById<TextView>(R.id.txtScore)
        val txtCurrentCorrect = intent.getIntExtra("correct",0)
        val txtCurrentIncorrect = intent.getIntExtra("incorrect", 0)
        val totalNumber = txtCurrentCorrect + txtCurrentIncorrect
        currentScore.text = "Your Current Score: " + txtCurrentCorrect.toString() + " / " + totalNumber.toString()

        val btnNext = findViewById<Button>(R.id.btnNext)
        var isLastQuestion = false
        if (intent.getIntExtra("questionNum", 3) == totalNumber) {
            isLastQuestion = true
            btnNext.text = "Finish"
        } else {
            btnNext.text = "Next"
        }
        val questionIndex = intent.getIntExtra("questionIndex", 1)
        val topicName = intent.getStringExtra("topicName")
        val questionNum = intent.getIntExtra("questionNum", 3)
        val correct = intent.getIntExtra("correct", 0)
        val incorrect = intent.getIntExtra("incorrect", 0)


        btnNext.setOnClickListener() {
            if (isLastQuestion) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, question::class.java)
                intent.putExtra("questionIndex", questionIndex + 1)
                intent.putExtra("topicName", topicName)
                intent.putExtra("questionNum", questionNum)
                intent.putExtra("correct", correct)
                intent.putExtra("incorrect", incorrect)
                startActivity(intent)
            }
        }
    }
}