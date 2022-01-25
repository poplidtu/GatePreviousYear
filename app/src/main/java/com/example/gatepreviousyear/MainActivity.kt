package com.example.gatepreviousyear

import android.content.ContentValues
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gatepreviousyear.R.id.drawerLayout
import com.example.gatepreviousyear.data.QuestionPaperContract
import com.example.gatepreviousyear.data.QuestionPaperDatabase
import com.example.gatepreviousyear.data.mydbAdapter
import com.example.gatepreviousyear.databinding.ActivityMainBinding
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.android.material.navigation.NavigationView
import java.security.AccessController.getContext
import java.sql.Types.NULL


class MainActivity : AppCompatActivity()  {
    lateinit  var drawer_layout : DrawerLayout

    var rowId : Long? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        val context = getContext()
        val Comptuer_Engineering = mydbAdapter(applicationContext)
        Computer_eng(Comptuer_Engineering)


        val navController = this.findNavController(R.id.myNavHostFragment)
        drawer_layout = findViewById(R.id.drawerLayout);

        NavigationUI.setupActionBarWithNavController(this,navController, drawer_layout)
        NavigationUI.setupWithNavController(findViewById<NavigationView>(R.id.navView),navController)



    }




    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController,drawer_layout) || super.onSupportNavigateUp()

       // NavigationUI.navigateUp(navController,drawerLayout) ||
    }

    fun Computer_eng(Computer_Engineering : mydbAdapter) {

          Computer_Engineering.insertData(201900001,getString(R.string.Question1_2019_set1),1,getString(R.string.option1_question1_2019_set1),getString(R.string.option2_question1_2019_set1),getString(R.string.option3_question1_2019_set1),getString(R.string.option4_question1_2019_set1),"2")
          Computer_Engineering.insertData(201900002,getString(R.string.Question2_2019_set1),NULL, "3","5","23","56","78")
          Computer_Engineering.insertData(201900003,getString(R.string.Question3_2019_set1),NULL, "12","56","78","90","12")
          Computer_Engineering.insertData(201900004,getString(R.string.Question4_2019_set1),NULL, "1","2","0","123","345")
          Computer_Engineering.insertData(201900005,getString(R.string.Question5_2019_set1),NULL, "23","12","25","27","29")
          Computer_Engineering.insertData(201900006,getString(R.string.Question6_2019_set1),NULL, "13","45","67","89","12")
          Computer_Engineering.insertData(201900007,"Compute : ",NULL, "1","2","3","4","12")
          Computer_Engineering.insertData(201900008,getString(R.string.Question8_2019_set1),NULL, "","","","","")
          Computer_Engineering.insertData(201900009,getString(R.string.Question9_2019_set1),NULL, "","","","","")
          Computer_Engineering.insertData(201900010,getString(R.string.Question10_2019_set1),NULL, "","","","","")
          Computer_Engineering.insertData(201900011,getString(R.string.Question11_2019_set1),NULL, "","","","","")
          Computer_Engineering.insertData(201900012,"Which one of the following is not a valid identity ?",NULL, "","","","","")
          Computer_Engineering.insertData(201900013,"Consider the following c program ",NULL, "","","","","")
          Computer_Engineering.insertData(201900014,getString(R.string.Question14_2019_set1),NULL, "","","","","")
        Computer_Engineering.insertData(201900015,getString(R.string.Question15_2019_set1),NULL, "","","","","")
        Computer_Engineering.insertData(201900016,getString(R.string.Question16_2019_set1),NULL, "","","","","")
        Computer_Engineering.insertData(201900017,getString(R.string.Question17_2019_set1),NULL, "","","","","")
        Computer_Engineering.insertData(201900018,getString(R.string.Question18_2019_set1),NULL, "","","","","")








    }





}