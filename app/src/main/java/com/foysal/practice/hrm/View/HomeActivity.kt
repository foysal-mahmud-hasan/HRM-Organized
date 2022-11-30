package com.foysal.practice.hrm.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.foysal.practice.hrm.HRMApplication
import com.foysal.practice.hrm.R
import com.foysal.practice.hrm.ViewModel.ExceptionViewModel
import com.foysal.practice.hrm.ViewModel.ExceptionViewModelFactory

lateinit var noteViewModel : ExceptionViewModel

class HomeActivity : AppCompatActivity() {

    lateinit var btnEntry: Button
    lateinit var btnAuthorize : Button

    lateinit var addActivityResultLauncher : ActivityResultLauncher<Intent>
    lateinit var editActivityResultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.title = "Home"

        val viewModelFactory = ExceptionViewModelFactory((application as HRMApplication).repository1)

        registerActivityResultLauncher()


        btnEntry = findViewById(R.id.ho_act_ex)
        btnAuthorize = findViewById(R.id.ho_act_aut)


        val id = intent.getStringExtra("id")
        val password = intent.getStringExtra("password")
        val tag = intent.getStringExtra("tag")

        if(tag == "Employee"){
            btnAuthorize.isVisible = false
        }
        btnEntry.setOnClickListener {
            val intent = Intent(this, ExceptionEntryActivity::class.java)
            intent.putExtra("id", id)
            intent.putExtra("password", password)
            intent.putExtra("tag", tag)
            startActivity(intent)
        }
        btnAuthorize.setOnClickListener{
            val intent = Intent(this,ExceptionAuthorizeActivity::class.java )
            intent.putExtra("id", id)
            intent.putExtra("password", password)
            intent.putExtra("tag", tag)
            startActivity(intent)
        }

    }

    private fun registerActivityResultLauncher() {
        TODO("Not yet implemented")
    }


}



