package com.example.roomdatabaseproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun UserDao(): UserDao //all your DAO will be added here    companion object {


    // Here we are creating singleton so it will give same      object every time instead of creating new.
    companion object{
        @Volatile
        private var INSTANCE: UserDatabase? = null
        private val DB_NAME: String="RoomDatabase" //Name of your database

        fun getDatabase(context: Context): UserDatabase? {
            if (INSTANCE == null) {
                synchronized(UserDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            UserDatabase::class.java, DB_NAME
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }

}
