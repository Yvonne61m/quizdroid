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
        val desRoute = resources.getIdentifier(txtName + "_description", "string", packageName)
        val txtDescription = getString(desRoute)
        description.text = txtDescription

        val total = findViewById<TextView>(R.id.txtQNum)
        val totalRoute = resources.getIdentifier(txtName + "_total", "string", packageName)
        val txtTotal = getString(totalRoute)
        total.text = "There are " + txtTotal + " questions"

        val btnBegin = findViewById<Button>(R.id.btnBegin)
        btnBegin.setOnClickListener() {
            val intent = Intent(this, question:: class.java)
            intent.putExtra("topicName",txtName)
            intent.putExtra("questionIndex",1)
            intent.putExtra("questionNum", txtTotal.toInt())
            intent.putExtra("correct", 0)
            intent.putExtra("incorrect",0)
            startActivity(intent)
        }
    }
}