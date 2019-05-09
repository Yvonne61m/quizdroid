package edu.us.ischool.yimengl.quizdroid

import android.app.Application
import android.util.Log

class QuizApp: Application(), TopicRepository {
    val data = TopicRepoClass()

    override fun onCreate() {
        super.onCreate()
        val TAG = "QuizApp"
        Log.i(TAG, "Hi! I'm the message!")
    }

    override fun getTopic(i: Int): TopicRepository.Topic {
        return data.getTopic(i)
    }
}
