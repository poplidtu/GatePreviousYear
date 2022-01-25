package com.example.gatepreviousyear

import android.app.ActionBar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.gatepreviousyear.databinding.FragmentYearListBinding


class YearList : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentYearListBinding>(inflater,R.layout.fragment_year_list,container,false)

       binding.ninteen.setOnClickListener { view :View ->
           Navigation.findNavController(view).navigate(R.id.action_yearList_to_questionPaper)
       }




        return binding.root
    }


}