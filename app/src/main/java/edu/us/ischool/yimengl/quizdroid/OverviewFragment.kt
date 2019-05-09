package edu.us.ischool.yimengl.quizdroid

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button


class OverviewFragment : Fragment() {
    companion object {
        private lateinit var topic: String
        fun newInstance(topic: String): OverviewFragment {
            val fragment = OverviewFragment()
            val bundle = Bundle()
            bundle.putString("topic", topic)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_overview, container, false)
        handleView(view)
        return view
    }

    fun handleView(view: View) {
        val name = view.findViewById<TextView>(R.id.txtTopicName)
        val description = view.findViewById<TextView>(R.id.txtDescription)
        val btnBegin = view.findViewById<Button>(R.id.btnBegin)
        val total = view.findViewById<TextView>(R.id.txtQNum)

        topic = arguments!!.getString("topic") as String
        name.text = topic

        var txtDescription = ""
        var txtTotal = 0
        lateinit var quizTopic: TopicRepository.Topic
        if (topic == "Math") {
            quizTopic = QuizApp().getTopic(0)

        } else if (topic == "Physics") {
            quizTopic = QuizApp().getTopic(1)

        } else if (topic == "MarvelSuperHeroes") {
            quizTopic = QuizApp().getTopic(2)
        }

        txtDescription = quizTopic.longDes
        txtTotal = quizTopic.questions.size
        description.text = txtDescription
        total.text = "There are " + txtTotal + " questions"

        btnBegin.setOnClickListener() {
            val questionFragment = QuestionFragment.newInstance(topic,0, 0,0)
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.fragments, questionFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}

//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//}
   //     private var listener: OnFragmentInteractionListener? = null

    //    fun onButtonPressed(uri: Uri) {
    //        listener?.onFragmentInteraction(uri)
    //    }
    //
    //    override fun onAttach(context: Context) {
    //        super.onAttach(context)
    //        if (context is OnFragmentInteractionListener) {
    //            listener = context
    //        } else {
    //            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
    //        }
    //    }
    //
    //    override fun onDetach() {
    //        super.onDetach()
    //        listener = null
    //    }
    //
    //    interface OnFragmentInteractionListener {
    //        fun onFragmentInteraction(uri: Uri)
    //    }





