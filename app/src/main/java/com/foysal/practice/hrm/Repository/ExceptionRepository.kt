package com.foysal.practice.hrm.Repository

import androidx.annotation.WorkerThread
import com.foysal.practice.hrm.Model.Exceptions
import com.foysal.practice.hrm.Room.ExceptionsDAO
import kotlinx.coroutines.flow.Flow


class ExceptionRepository(private val exceptionDAO : ExceptionsDAO) {

    val exceptionList : Flow<List<Exceptions>> = exceptionDAO.getAllExceptions()

    @WorkerThread
    suspend fun insert(exception : Exceptions){

        exceptionDAO.insert(exception)

    }
    @WorkerThread
    suspend fun update(exception : Exceptions){

        exceptionDAO.update(exception)

    }
    @WorkerThread
    suspend fun delete(exception : Exceptions){

        exceptionDAO.delete(exception)

    }



}