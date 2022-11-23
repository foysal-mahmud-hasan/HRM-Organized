package com.foysal.practice.hrm.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.foysal.practice.hrm.Model.Exceptions
import com.foysal.practice.hrm.Model.UserWithExceptions
import kotlinx.coroutines.flow.Flow


@Dao
interface ExceptionsDAO {

    @Insert
    suspend fun insert(exceptions : Exceptions)

    @Update
    suspend fun update(exceptions : Exceptions)

    @Delete
    suspend fun delete(exceptions : Exceptions)

    @Query
    ("SELECT * FROM EXCEPTION_TABLE ORDER BY id ASC")
    fun getAllExceptions() : Flow<List<Exceptions>>

}