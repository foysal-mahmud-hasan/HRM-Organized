package com.foysal.practice.hrm.Model

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithExceptions(

    @Embedded val usersEntity: Users,

    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val listExceptions : List<Exceptions>

)