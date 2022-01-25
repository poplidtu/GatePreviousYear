
package com.example.gatepreviousyear.data

import android.provider.BaseColumns

object  QuestionPaperContract {

    object QuestionEntry : BaseColumns {
        const val TABLE_NAME = "QuestionPaper2019"
        const val QUESTION = "question"
        const val QNO = "question_number"
        const val MARKS = "marks"
        const val OPTIONI = "option1"
        const val OPTIONII = "option2"
        const val OPTIONIII = "option3"
        const val OPTIONIV = "option4"
        const val ANSWER =  "answer"
    }
}


