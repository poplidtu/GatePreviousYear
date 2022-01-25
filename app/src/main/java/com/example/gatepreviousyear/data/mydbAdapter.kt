package com.example.gatepreviousyear.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import android.view.Gravity.apply
import androidx.core.view.GravityCompat.apply

public class mydbAdapter(context : Context) {

    val dbhelper : QuestionPaperDatabase = QuestionPaperDatabase(context)

    public fun insertData(QuestionId : Int, Question : String,marks : Int ,Option1 : String, Option2 : String, Option3 : String , Option4 : String, answer : String) {
        val db =  dbhelper.writableDatabase
        val values = ContentValues().apply {
            put(QuestionPaperContract.QuestionEntry.QUESTION,Question)
            put(QuestionPaperContract.QuestionEntry.QNO, QuestionId)
            put(QuestionPaperContract.QuestionEntry.MARKS,marks)
            put(QuestionPaperContract.QuestionEntry.OPTIONI,Option1)
            put(QuestionPaperContract.QuestionEntry.OPTIONII, Option2)
            put(QuestionPaperContract.QuestionEntry.OPTIONIII,Option3)
            put(QuestionPaperContract.QuestionEntry.OPTIONIV, Option4)
            put(QuestionPaperContract.QuestionEntry.ANSWER, answer)
        }
         db?.insert(QuestionPaperContract.QuestionEntry.TABLE_NAME, null, values)





    }


    public fun delete(QuestionId : Int) : Boolean{
        val db = dbhelper.writableDatabase
        val selectionArgs = QuestionId.toString()
       return  db.delete(QuestionPaperContract.QuestionEntry.TABLE_NAME,QuestionPaperContract.QuestionEntry.QNO +"="+QuestionId ,null) >0
    }

  public fun Query(): Cursor? {
      val db = dbhelper.writableDatabase
      val projection = arrayOf(QuestionPaperContract.QuestionEntry.QUESTION,QuestionPaperContract.QuestionEntry.OPTIONI,
          QuestionPaperContract.QuestionEntry.OPTIONII,QuestionPaperContract.QuestionEntry.OPTIONIII,QuestionPaperContract.QuestionEntry.OPTIONIV,
          QuestionPaperContract.QuestionEntry.ANSWER,QuestionPaperContract.QuestionEntry.MARKS)
      val cursor = db.query(QuestionPaperContract.QuestionEntry.TABLE_NAME,null,null,null,null,null,null)
        Log.i("mydbAdapter", "cursor value " + cursor)
        return cursor

  }


}