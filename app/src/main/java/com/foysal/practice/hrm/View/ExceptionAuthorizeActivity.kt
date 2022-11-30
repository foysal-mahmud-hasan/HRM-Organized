package com.foysal.practice.hrm.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.foysal.practice.hrm.Model.Exceptions
import com.foysal.practice.hrm.R
import com.foysal.practice.hrm.ViewModel.ExceptionViewModel

lateinit var exceptionViewModel: ExceptionViewModel

class ExceptionAuthorizeActivity : AppCompatActivity() {

    lateinit var addActivityResultLauncher : ActivityResultLauncher<Intent>
    lateinit var editActivityResultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exception_authorize)

        supportActionBar?.title = "Exception Authorize"

    }

    fun registerActivityResultLauncher(){

        addActivityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
            , ActivityResultCallback { resultAddException ->

                val resultCode = resultAddException.resultCode
                val data = resultAddException.data

                if ( resultCode == RESULT_OK && data != null){

                    TODO()

//                    val noteTitle : String = data.getStringExtra("title").toString()
//                    val noteDescription : String = data.getStringExtra("description").toString()
//
//                    val note = Note(noteTitle, noteDescription)
//                    noteViewModel.insert(note)

                }

            })
        editActivityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
            , ActivityResultCallback { resultEditNote ->

                val resultCode = resultEditNote.resultCode
                val data = resultEditNote.data

                if ( resultCode == RESULT_OK && data != null){

                    val textViewName : String = data.getStringExtra("textViewName" ).toString()
                    val textViewId : String = data.getStringExtra("textViewId").toString()
                    val textViewStatus : String = data.getStringExtra("textViewStatus").toString()
                    val authReason : String = data.getStringExtra("authReason").toString()
                    val date : String = data.getStringExtra("date").toString()
                    val dateType : String = data.getStringExtra("dateType").toString()
                    val userId : String = data.getStringExtra("userId").toString()
                    val newException = Exceptions(textViewId.toInt(), textViewName, date, dateType, authReason
                    , textViewStatus, userId)
                    exceptionViewModel.update(newException)

                }

            })

    }
}