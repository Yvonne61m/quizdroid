package edu.us.ischool.yimengl.quizdroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.content.Intent

class topicOverview: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_overview)

        val name = findViewById<TextView>(R.id.txtTopicName)
        val txtName = intent.getStringExtra("item")
        name.text = txtName

        val description = findViewById<TextView>(R.id.txtDescription)
        val txtDescription = when(txtName) {
            "Math" -> getString(R.string.quiz1_description)
            "Physics" -> getString(R.string.quiz2_description)
            "Marvel Super Heroes" -> getString(R.string.quiz3_description)
            else -> ""
        }
        description.text = txtDescription

        val qNum = findViewById<TextView>(R.id.txtQNum)
        val txtQNum = when(txtName) {
            "Math" -> getString(R.string.quiz1_QNum)
            "Physics" -> getString(R.string.quiz2_QNum)
            "Marvel Super Heroes" -> getString(R.string.quiz3_QNum)
            else -> ""
        }
        qNum.text = "There are " + txtQNum + " questions"

        val btnBegin = findViewById<Button>(R.id.btnBegin)
        btnBegin.setOnClickListener() {
            val intent = Intent(this, question:: class.java)
            intent.putExtra("topicName",txtName)
            intent.putExtra("questionIndex",1)
            intent.putExtra("questionNum", txtQNum)
            startActivity(intent)
        }
    }
}