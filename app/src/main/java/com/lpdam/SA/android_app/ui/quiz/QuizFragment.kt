package com.lpdam.SA.android_app.ui.quiz
/*
    Quiz activity which takes it sources in the ressource/string file
    A good answer on click will color the answer in blue and a bad click will color it in red
 */
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lpdam.SA.android_app.R
import com.lpdam.SA.android_app.models.Quiz
import kotlinx.android.synthetic.main.fragment_quiz.*

class QuizFragment : Fragment() {

    private lateinit var quizViewModel: QuizViewModel
    private var quizs = ArrayList<Quiz>()
    private var currentQuizIndex : Int = 0
    private var nbResponsesFounded : Int = 0
    private var responses = mutableListOf<TextView>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        quizViewModel =
            ViewModelProviders.of(this).get(QuizViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_quiz, container, false)
        quizs.add(Quiz(resources.getString(R.string.quiz_question_one), resources.getStringArray(R.array.quiz_responses_0), resources.getStringArray(R.array.quiz_solutions_0)))
        quizs.add(Quiz(getString(R.string.quiz_question_two), resources.getStringArray(R.array.quiz_responses_1), resources.getStringArray(R.array.quiz_solutions_1)))
        quizs.add(Quiz(getString(R.string.quiz_question_three), resources.getStringArray(R.array.quiz_responses_2), resources.getStringArray(R.array.quiz_solutions_2)))
        quizs.add(Quiz(getString(R.string.quiz_question_four), resources.getStringArray(R.array.quiz_responses_3), resources.getStringArray(R.array.quiz_solutions_3)))
        quizs.add(Quiz(getString(R.string.quiz_question_five), resources.getStringArray(R.array.quiz_responses_4), resources.getStringArray(R.array.quiz_solutions_4)))


        quizViewModel.text.observe(this, Observer {
            responses.add(response0)
            responses.add(response1)
            responses.add(response2)
            responses.add(response3)
            responses.add(response4)
            showQuestion(quizs[currentQuizIndex])
        })
        return root
    }

    // load the quiz and pop the question
    private fun showQuestion(quiz : Quiz) {
        question.text = quiz.question
        var nbResponses = quizs[currentQuizIndex].answers.count()
        for (i in 0 .. nbResponses-1) {
            responses[i].visibility = View.VISIBLE
            responses[i].text = quiz.answers[i]
            responses[i].setOnClickListener {
                onClick(i)
            }
        }
        for (j in nbResponses..4) {
            responses[j].visibility = View.INVISIBLE
        }

    }

    // check if all responses as been founded
    private fun checkResponse() {
        if(nbResponsesFounded == quizs[currentQuizIndex].correctAnswer.size) {
            if(quizs.size-1 > currentQuizIndex) {
                currentQuizIndex++
                nbResponsesFounded = 0
                for (t in responses) {
                    t.setTextColor(Color.BLACK)
                }
                showQuestion(quizs[currentQuizIndex])
            } else {
                question.text = "Well done !"
                for (t in responses) {
                    t.visibility = View.INVISIBLE
                }
            }
        }
    }

    // click listener for responses
    private fun onClick(id: Int) {
        val quiz = quizs[currentQuizIndex]
        if(quiz.correctAnswer.contains(quiz.answers[id])) {
            responses[id].setTextColor(Color.BLUE)
            nbResponsesFounded++
        } else {
            responses[id].setTextColor(Color.RED)
        }
        checkResponse()
    }
}