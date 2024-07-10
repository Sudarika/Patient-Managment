package com.example.final_lab3

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.final_lab3.database.Patient
import com.example.final_lab3.database.PatientRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PatientAdapter(items:List<Patient>,repository: PatientRepository,viewModel: MainActivityData) : RecyclerView.Adapter<PatientView_Holder>() {
    lateinit var  context:Context
    val items=items
    val repository=repository
    val viewModel=viewModel


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientView_Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item,parent,false)
        return PatientView_Holder(view)
    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: PatientView_Holder, position: Int) {
        val patient = items[position]
        holder.Dname.text= patient.doctorname
        holder.Pname.text=patient.name
        holder.Date.text=patient.date
        holder.cbNews.text=items.get(position).name
        holder.ivDelete.setOnClickListener {
            val isChecked = holder.cbNews.isChecked

            /*Toast.makeText(context,"Hello",Toast.LENGTH_LONG).show()*/
            if (isChecked) {
                CoroutineScope(Dispatchers.IO).launch {
                    repository.delete(items.get(position))
                    val data = repository.getAllPatientDetails()
                    withContext(Dispatchers.Main){
                        viewModel.setData(data)
                    }
                }
                Toast.makeText(context,"Item Deleted",Toast.LENGTH_LONG).show()


            } else {
                Toast.makeText(context, "Select One to Delete", Toast.LENGTH_LONG).show()
            }


        }
    }
}