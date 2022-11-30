package com.foysal.practice.hrm.Repository

import androidx.annotation.WorkerThread
import com.foysal.practice.hrm.Model.UserWithExceptions
import com.foysal.practice.hrm.Model.Users
import com.foysal.practice.hrm.Room.UsersDAO
import kotlinx.coroutines.flow.Flow


class UserRepository( private val usersDAO: UsersDAO) {

    val allUsers : Flow<List<Users>> = usersDAO.getAllUsers()
    val allUser : List<Users> = usersDAO.getAllUser()
    val userExceptionList : Flow<List<UserWithExceptions>> = usersDAO.getUserExceptions()

    @WorkerThread
    suspend fun insert(user : Users){

        usersDAO.insert(user)

    }

    @WorkerThread
    suspend fun update(user : Users){

        usersDAO.update(user)

    }
    @WorkerThread
    suspend fun delete(user : Users){

        usersDAO.delete(user)

    }

}