package com.foysal.practice.hrm.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "exception_table")
data class Exceptions(@PrimaryKey val id: Int,
                      val name : String,
                      val date : String,
                      val dateType : String,
                      val reason : String,
                      val status : String,
                      val userId : String)