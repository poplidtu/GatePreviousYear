package com.example.gatepreviousyear

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gatepreviousyear.data.mydbAdapter
import com.example.gatepreviousyear.databinding.FragmentQuestionPaperBinding


class QuestionPaper : Fragment() {
    data class Questions(val Question : String,val Option1 : String, val Option2 :String, val Option3 : String,val Option4 : String,val Marks : Int, val answer : String);
    var data = ArrayList<Questions>()
    var question_attempted  : Int = 0;
    lateinit var Question : String
    lateinit var option1 : String
    lateinit var option2 : String
    lateinit var option3 : String
    lateinit var option4 : String
    lateinit var answer : String
     var marks : Int = 0
    val total_question = 28;
    var total_marks = 0;
    var counter1 = 0;
    var hour1 = 0;
    var minutes1 = 0;
    var seconds1 = 0;
    var time1 : String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentQuestionPaperBinding>(inflater,R.layout.fragment_question_paper,container,false)
        val navController = findNavController()
            activity!!.setTitle("Question Paper")

        binding.submitPaper.setOnClickListener {view ->
          //  CheckingQuestions(binding)
          //  view.findNavController().navigate(QuestionPaperDirections.actionQuestionPaperToResult(question_attempted,total_question,total_marks))
        view.findNavController().navigate(R.id.action_questionPaper_to_result)
        }

        binding.cancelPaper.setOnClickListener {
            navController.navigate(R.id.action_questionPaper_to_yearList)
        }

        timerForTest(binding, navController)


        val recyclerView : RecyclerView = binding.QuestionRecyclerView


        val dbhelper = mydbAdapter(context!!)

        val cursor = dbhelper.Query()

        cursor!!.moveToPosition(-1)
        while(cursor.moveToNext()){
            Question = cursor.getString(1)
            option1 = cursor.getString(3)
            option2 = cursor.getString(4)
            option3 = cursor.getString(5)
            option4 = cursor.getString(6)
            marks = cursor.getInt(0)
            answer = cursor.getString(7)

            data.add(Questions(Question, option1, option2, option3, option4,marks,answer))
            Log.i("Activity main ", " cursor value " + cursor + " "+cursor.getString(1));


        }


  //      val adapter = QuestionAdapter(data,context!!)
        recyclerView.adapter = QuestionAdapter(data, context!!)
        recyclerView.layoutManager = LinearLayoutManager(this.context)




        return binding.root
    }


    private fun timerForTest( binding: FragmentQuestionPaperBinding, navController: NavController) {

        object : CountDownTimer(10800000, 1000) {
            override fun onTick(finished: Long) {


                minutes1 = counter1 / 60
                seconds1 = counter1 % 60
                hour1 = counter1 / 3600

                if (seconds1 < 10 && minutes1 < 10) time1 = "0$hour1:0$minutes1:0$seconds1"
                else if (minutes1 < 10 && seconds1 >= 10) time1 = "0$hour1:0$minutes1:$seconds1"
                else if (seconds1 < 10 && minutes1 >= 10) time1 = "0$hour1:$minutes1:0$seconds1"
                else time1 = "0$hour1:$minutes1:$seconds1"


                binding.time.text = time1

                if (counter1 % 3600 == 0) minutes1 = 0
              //  Log.i("My Activity", "value of the counter $counter1")


                counter1++
            }

            override fun onFinish() {

                navController.navigate(R.id.result)
            }


        }.start();
    }


}

