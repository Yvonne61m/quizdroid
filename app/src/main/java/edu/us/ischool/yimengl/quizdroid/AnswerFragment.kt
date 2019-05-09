package edu.us.ischool.yimengl.quizdroid

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class AnswerFragment : Fragment() {
    companion object {
        fun newInstance(topic: String, questionIndex: Int, correct: Int, incorrect: Int, userAnswer: String): AnswerFragment {
            val fragment = AnswerFragment()
            val bundle = Bundle()
            bundle.putString("topic", topic)
            bundle.putInt("questionIndex", questionIndex)
            bundle.putInt("correct", correct)
            bundle.putInt("incorrect", incorrect)
            bundle.putString("userAnswer", userAnswer)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_answer, container, false)

        val yourAnswer = view.findViewById<TextView>(R.id.txtYourAnswer)
        val currentScore = view.findViewById<TextView>(R.id.txtScore)
        val correctAnswer = view.findViewById<TextView>(R.id.txtCorrectAnswer)
        val btnNext = view.findViewById<Button>(R.id.btnNext)

        val topic = arguments!!.getString("topic") as String
        lateinit var quizTopic: TopicRepository.Topic
        if (topic == "Math") {
            quizTopic = QuizApp().getTopic(0)

        } else if (topic == "Physics") {
            quizTopic = QuizApp().getTopic(1)

        } else if (topic == "MarvelSuperHeroes") {
            quizTopic = QuizApp().getTopic(2)
        }

        val questionIndex = arguments!!.getInt("questionIndex",0)
        val correct = arguments!!.getInt("correct",0)
        val incorrect = arguments!!.getInt("incorrect",0)
        val userAnswer = arguments!!.getString("userAnswer")

        val txtCorrectAnswer = quizTopic.questions[questionIndex].answers[quizTopic.questions[questionIndex].correct - 1]
        val totalAnswer = correct + incorrect
        val total = quizTopic.questions.size

        correctAnswer.text = "Correct Answer: " + txtCorrectAnswer
        yourAnswer.text = "Your Answer: " + userAnswer
        currentScore.text = "Your Current Score: " + correct.toString() + " / " + totalAnswer.toString()

        var isLastQuestion = false
        if ( total == totalAnswer) {
            isLastQuestion = true
            btnNext.text = "Finish"
        } else {
            btnNext.text = "Next"
        }

        btnNext.setOnClickListener() {
            val transaction = fragmentManager!!.beginTransaction()
            if (isLastQuestion) {
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            } else {
                val questionFragment = QuestionFragment.newInstance(topic, questionIndex + 1, correct, incorrect)
                transaction.replace(R.id.fragments,questionFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }

        return view
    }


}
