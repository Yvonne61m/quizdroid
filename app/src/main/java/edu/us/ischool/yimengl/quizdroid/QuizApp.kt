package edu.us.ischool.yimengl.quizdroid

import android.app.Application
import android.util.Log

class QuizApp: Application(), TopicRepository {

    companion object {
        private val ourInstance = QuizApp()

        fun getInstance(): QuizApp {
            return ourInstance
        }
    }

    private fun constructor() {

    }

    override fun onCreate() {
        super.onCreate()
        val TAG = "QuizApp"
        Log.i(TAG, "Hi! I'm the message!")
    }


    private val data = TopicRepoClass()
    override fun getTopic(i: Int): TopicRepository.Topic {
        return data.getTopic(i)
    }
}
