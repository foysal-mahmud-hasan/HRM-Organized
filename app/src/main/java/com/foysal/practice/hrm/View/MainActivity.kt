package com.foysal.practice.hrm.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.foysal.practice.hrm.HRMApplication
import com.foysal.practice.hrm.Model.Users
import com.foysal.practice.hrm.R
import com.foysal.practice.hrm.Repository.UserRepository
import com.foysal.practice.hrm.Room.UserDatabase
import com.foysal.practice.hrm.Room.UsersDAO
import com.foysal.practice.hrm.ViewModel.ExceptionViewModel
import es.dmoral.toasty.Toasty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


class MainActivity : AppCompatActivity() {

    lateinit var editTextLoginId : EditText
    lateinit var editTextLoginPass : EditText
    lateinit var btnLogin : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var application = HRMApplication()

        val userDatabase by lazy {UserDatabase.getDatabase(this, application.applicationScope)}
        val repository by lazy { UserRepository(userDatabase.getUserDao()) }


        val users : List<Users> = repository.allUser

        editTextLoginId = findViewById(R.id.login_id)
        editTextLoginPass = findViewById(R.id.login_pass)
        btnLogin = findViewById(R.id.btn_login)


        btnLogin.setOnClickListener{

            val id = editTextLoginId.text.toString()
            val pass = editTextLoginPass.text.toString()

            if(editTextLoginId.text.toString().isEmpty()){
                Toasty.warning(this,
                    "Please Enter Your Id", Toast.LENGTH_SHORT).show()
            }else if(editTextLoginPass.text.toString().isEmpty()){
                Toasty.warning(this,
                    "Please Enter Your Password", Toast.LENGTH_SHORT).show()
            }else{
                login(id, pass, users)
            }

        }







    }

    private fun login(id: String, pass: String, users: List<Users>) {

        for (i in users){

            if(i.id.toString() == id && i.password == pass){
                /*Log.i("Size", "${i!!.tag}")*/
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id", id)
                intent.putExtra("password", pass)
                intent.putExtra("tag", i.userRole)
                Toasty.success(this,"Success", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }else{
                Toasty.warning(this, "wrong id/password", Toast.LENGTH_LONG).show()
            }


        }

    }
}