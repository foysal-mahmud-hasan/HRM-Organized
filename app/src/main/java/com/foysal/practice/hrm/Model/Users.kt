package com.foysal.practice.hrm.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class Users (@PrimaryKey val id : Int,
                  val password : String,
                  val userRole : String)
