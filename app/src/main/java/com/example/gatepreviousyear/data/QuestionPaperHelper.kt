
package com.example.gatepreviousyear.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.gatepreviousyear.QuestionPaper
import java.sql.Types.NULL

class QuestionPaperDatabase(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {


    override fun onCreate(db : SQLiteDatabase?) {

         val SQL_CREATE_ENTRIES =  "CREATE TABLE ${QuestionPaperContract.QuestionEntry.TABLE_NAME} (" +
                "${QuestionPaperContract.QuestionEntry.QNO} INTEGER PRIMARY KEY ," +
                "${QuestionPaperContract.QuestionEntry.QUESTION} TEXT," +
                "${QuestionPaperContract.QuestionEntry.MARKS} INTEGER," +
                "${QuestionPaperContract.QuestionEntry.OPTIONI} TEXT," +
                "${QuestionPaperContract.QuestionEntry.OPTIONII} TEXT," +
                "${QuestionPaperContract.QuestionEntry.OPTIONIII} TEXT," +
                "${QuestionPaperContract.QuestionEntry.OPTIONIV} TEXT,"+
                "${QuestionPaperContract.QuestionEntry.ANSWER} TEXT)"
            db?.execSQL(SQL_CREATE_ENTRIES)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }



    companion object {
        const val DATABASE_NAME = "Questions.db"
        const val DATABASE_VERSION =1
    }
}


