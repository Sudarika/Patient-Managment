package com.example.final_lab3.database

class PatientRepository (
private val db:PatientDatabase
) {
    suspend fun insert(todo:Patient) = db.getTodoDao().insertTodo(todo)
    suspend fun delete(todo:Patient) = db.getTodoDao().deleteTodo(todo)
    fun getAllPatientDetails():List<Patient> = db.getTodoDao().getAllPatientDetails()
}

