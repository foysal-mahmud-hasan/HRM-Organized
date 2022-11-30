package com.foysal.practice.hrm.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.foysal.practice.hrm.Model.Exceptions
import com.foysal.practice.hrm.Model.Users
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.reflect.KParameter


@Database (entities = [Users::class, Exceptions::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao() : UsersDAO
    abstract fun getExceptionDao() : ExceptionsDAO

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): UserDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java , "user_database"
                )
                    .addCallback(UserDatabaseCallback(scope)).allowMainThreadQueries()
                    .build()

                INSTANCE = instance

                instance
            }

        }

    }
    class UserDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { database ->

                scope.launch {

                    val usersDAO = database.getUserDao()

                    usersDAO.insert(Users(1, "1234", "admin"))
                    usersDAO.insert(Users(2, "1235", "employee"))
                    usersDAO.insert(Users(3, "1236", "employee"))
                }

            }

        }

    }

}


