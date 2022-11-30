package com.foysal.practice.hrm.Room

import androidx.room.*
import com.foysal.practice.hrm.Model.UserWithExceptions
import com.foysal.practice.hrm.Model.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDAO {

    @Insert
    suspend fun insert(users: Users)

    @Update
    suspend fun update(users: Users)

    @Delete
    suspend fun delete(users: Users)

    @Transaction
    @Query
        ("SELECT * FROM users ORDER BY id ASC")
    fun getUserExceptions() : Flow<List<UserWithExceptions>>

    @Query
        ("SELECT * FROM users ORDER BY id ASC")
    fun getAllUsers() : Flow<List<Users>>

    @Query
        ("SELECT * FROM users")
    fun getAllUser() : List<Users>


}