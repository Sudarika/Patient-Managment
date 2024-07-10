package com.example.final_lab3

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PatientView_Holder (view: View): RecyclerView.ViewHolder(view) {
    val cbNews: CheckBox= view.findViewById(R.id.cbNews)
    val ivDelete: ImageView =view.findViewById(R.id.ivDelete)
    val Dname:TextView = view.findViewById(R.id.descriptionTextView)
    val Date:TextView = view.findViewById(R.id.dateTextView)
    val Pname:TextView = view.findViewById(R.id.pname)


}
