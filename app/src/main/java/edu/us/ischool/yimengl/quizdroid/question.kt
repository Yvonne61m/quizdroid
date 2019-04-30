package edu.us.ischool.yimengl.quizdroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.RadioGroup
import android.widget.RadioButton
import android.content.Intent

class question: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val currentName = findViewById<TextView>(R.id.txtQTopic)
        val txtCurrentName = intent.getStringExtra("topicName")
        currentName.text = txtCurrentName

        val currentIndex = intent.getIntExtra("questionIndex", 1)
        val currentQuestion = findViewById<TextView>(R.id.txtQ)
        val currentQuestionRoute = resources.getIdentifier(txtCurrentName + "_Q" + currentIndex,"string", packageName)
        val txtQuestion = getString(currentQuestionRoute)
        currentQuestion.text = txtQuestion

        val radioGroup = findViewById<RadioGroup>(R.id.answers)
        val answerButtons = radioGroup.touchables

        for (i in 0..3) {
            val answerButton = answerButtons[i] as RadioButton
            val anRoute = resources.getIdentifier(txtCurrentName + "_Q" + currentIndex + "_Answers", "array", packageName)
            val txtAnswer = resources.getStringArray(anRoute)[i]
            answerButton.text = txtAnswer
        }

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        btnSubmit.isEnabled = false
        radioGroup.setOnCheckedChangeListener { _, _ ->
            btnSubmit.isEnabled = true
        }

        var correct = intent.getIntExtra("correct", 0)
        var incorrect = intent.getIntExtra("incorrect", 0)
        val correctAnswerRoute = resources.getIdentifier(txtCurrentName + "_Q" + currentIndex + "_correctA", "string", packageName)
        val correctAnswer = getString(correctAnswerRoute)
        val totalQuestion = intent.getIntExtra("questionNum",3)

        btnSubmit.setOnClickListener() {
            val userAnswer = findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text
            if (userAnswer == correctAnswer) {
                correct += 1
            } else {
                incorrect += 1
            }
            val intent = Intent(this, answer::class.java)
            intent.putExtra("topicName", txtCurrentName)
            intent.putExtra("questionIndex", currentIndex)
            intent.putExtra("questionNum", totalQuestion)
            intent.putExtra("correct", correct)
            intent.putExtra("incorrect", incorrect)
            intent.putExtra("correctAnswer", correctAnswer)
            intent.putExtra("userAnswer", userAnswer)

            startActivity(intent)
        }
    }
}