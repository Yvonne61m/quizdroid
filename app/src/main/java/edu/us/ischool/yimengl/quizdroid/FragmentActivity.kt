package edu.us.ischool.yimengl.quizdroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.widget.Button
import android.widget.TextView
import android.content.Intent

class FragmentActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.topic_fragments)

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        val topic = intent.getStringExtra("item").replace(" ","")
        val overviewFragment = OverviewFragment.newInstance(topic)
        transaction.replace(R.id.fragments, overviewFragment)
        transaction.commit()
    }
}