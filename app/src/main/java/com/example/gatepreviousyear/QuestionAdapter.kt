package com.example.gatepreviousyear

import android.content.Context
import android.database.Cursor
import android.database.DataSetObserver
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ListAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.sql.Types.NULL

class QuestionAdapter(data : ArrayList<QuestionPaper.Questions>, var context : Context):
    RecyclerView.Adapter<QuestionAdapter.ViewHolder>(), ListAdapter {
    var data : ArrayList<QuestionPaper.Questions> = data
    var marks : Int = 0


    class ViewHolder(itemView : View)  :RecyclerView.ViewHolder(itemView){


        var  Question : TextView
        var  option1 : RadioButton
        var  option2 : RadioButton
        var  option3 : RadioButton
        var  option4 : RadioButton
        var radioGroup : RadioGroup

        init{
            Question = itemView.findViewById(R.id.realQuestion)
            option1 = itemView.findViewById(R.id.option1)
            option2 = itemView.findViewById(R.id.option2)
            option3 = itemView.findViewById(R.id.option3)
            option4 = itemView.findViewById(R.id.option4)
            radioGroup = itemView.findViewById(R.id.RadioGroup)

        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layout = LayoutInflater.from(context).inflate((R.layout.question_style),parent,false)

        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.Question.text = data[position].Question
        holder.option1.text = data[position].Option1
        holder.option2.text = data[position].Option2
        holder.option3.text = data[position].Option3
        holder.option4.text = data[position].Option4
   //     Log.i("Adapter","radioGroup number : "+holder.radioGroup.id)

    }



    override fun getItemCount(): Int {

        return data.size
    }

    override fun registerDataSetObserver(p0: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun unregisterDataSetObserver(p0: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(p0: Int): Any {


        TODO("Not yet implemented")
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {


        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {

        return data.isEmpty()
    }

    override fun areAllItemsEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(p0: Int): Boolean {
        TODO("Not yet implemented")
    }


}
