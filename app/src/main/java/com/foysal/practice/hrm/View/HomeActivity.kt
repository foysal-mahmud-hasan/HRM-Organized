package com.foysal.practice.hrm.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.foysal.practice.hrm.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.title = "Home"

    }
}