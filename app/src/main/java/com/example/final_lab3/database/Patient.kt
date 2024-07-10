package com.example.final_lab3.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Patient(
    var name: String?,
    var doctorname:String?,
    var date:String?,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}


