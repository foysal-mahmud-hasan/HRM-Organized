package com.foysal.practice.hrm

import android.app.Application
import com.foysal.practice.hrm.Repository.UserRepository
import com.foysal.practice.hrm.Room.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class HRMApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {UserDatabase.getDatabase(this, applicationScope)}
    val repository by lazy { UserRepository(database.getUserDao()) }


}