package edu.us.ischool.yimengl.quizdroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class question: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)


        val currentName = findViewById<TextView>(R.id.txtQTopic)
        val txtCurrentName = intent.getStringExtra("topicName")
        currentName.text = txtCurrentName

        val questionIndex = intent.getIntExtra("questionIndex", 1)
        val currentQuestion = findViewById<TextView>(R.id.txtQ)

    }
}