package com.example.final_lab3.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Patient::class], version = 1)
abstract class PatientDatabase : RoomDatabase(){
    abstract fun getTodoDao():PatientDao
    companion object{
        @Volatile
        private var INSTANCE: PatientDatabase? = null
        fun getInstance(context: Context):PatientDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    PatientDatabase::class.java,
                    "patient_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
