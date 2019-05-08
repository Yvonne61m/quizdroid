package edu.us.ischool.yimengl.quizdroid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView


class QuestionFragment : Fragment() {

    companion object {
        private lateinit var topic: String
        fun newInstance(topic: String, questionIndex: Int, correct: Int, incorrect: Int): QuestionFragment {
            val fragment = QuestionFragment()
            val bundle = Bundle()
            bundle.putString("topic", topic)
            bundle.putInt("questionIndex", questionIndex)
            bundle.putInt("correct", correct)
            bundle.putInt("incorrect", incorrect)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question, container, false)

        val name = view.findViewById<TextView>(R.id.txtQTopic)
        val radioGroup = view.findViewById<RadioGroup>(R.id.answers)
        val question = view.findViewById<TextView>(R.id.txtQ)
        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)

        topic = arguments!!.getString("topic") as String
        val questionIndex = arguments!!.getInt("questionIndex",1)
        var correct = arguments!!.getInt("correct",0)
        var incorrect = arguments!!.getInt("incorrect",0)
        val currentQuestionRoute = resources.getIdentifier(topic + "_Q" + questionIndex,"string", getActivity()!!.getPackageName())
        val txtQuestion = getString(currentQuestionRoute)

        name.text = topic
        question.text = txtQuestion

        val answerButtons = radioGroup.touchables
        for (i in 0..3) {
            val answerButton = answerButtons[i] as RadioButton
            val anRoute = resources.getIdentifier(topic + "_Q" + questionIndex + "_Answers", "array", getActivity()!!.getPackageName())
            val txtAnswer = resources.getStringArray(anRoute)[i]
            answerButton.text = txtAnswer
        }

        btnSubmit.isEnabled = false
        radioGroup.setOnCheckedChangeListener { _, _ ->
            btnSubmit.isEnabled = true
        }

        val correctAnswerRoute = resources.getIdentifier(topic + "_Q" + questionIndex + "_correctA", "string", getActivity()!!.getPackageName())
        val correctAnswer = getString(correctAnswerRoute)
        val totalRoute = resources.getIdentifier(topic + "_total", "string", getActivity()!!.getPackageName())
        val Total = getString(totalRoute)

        btnSubmit.setOnClickListener() {
            val userAnswer = view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text as String
            if (userAnswer == correctAnswer) {
                correct += 1
            } else {
                incorrect += 1
            }
            val transaction = fragmentManager!!.beginTransaction()
            val answerFragment = AnswerFragment.newInstance(topic,questionIndex,correct,incorrect,userAnswer)
            transaction.replace(R.id.fragments,answerFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        return view
    }
}

