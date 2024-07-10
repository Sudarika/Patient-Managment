package com.example.final_lab3.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PatientDao {
    @Insert
    suspend fun insertTodo(todo: Patient)
    @Delete
    suspend fun deleteTodo(todo: Patient)
    @Query("SELECT * FROM Patient")
    fun getAllPatientDetails():List<Patient>
}