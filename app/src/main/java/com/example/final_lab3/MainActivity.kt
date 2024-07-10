package com.example.final_lab3

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.final_lab3.database.Patient
import com.example.final_lab3.database.PatientDatabase
import com.example.final_lab3.database.PatientRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var adapter:PatientAdapter
    private lateinit var viewModel:MainActivityData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView=findViewById(R.id.rvList)
        val repository=PatientRepository(PatientDatabase.getInstance(this))
        viewModel=ViewModelProvider(this)[MainActivityData::class.java]

        viewModel.data.observe(this) {
            adapter = PatientAdapter(it,repository,viewModel)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)

        }
        CoroutineScope(Dispatchers.IO).launch {
            val data = repository.getAllPatientDetails()
            runOnUiThread {
                viewModel.setData(data)
            }
        }
        val btnAddItem: Button = findViewById(R.id.btnadd)
        btnAddItem.setOnClickListener {
            displayDialog(repository)
        }
    }
   private fun displayDialog(repository: PatientRepository) {
       val builder = AlertDialog.Builder(this)
       val dialogView = layoutInflater.inflate(R.layout.add_petient_dialog, null)
       val edt1 = dialogView.findViewById<EditText>(R.id.editTextText4)
       val edt2 = dialogView.findViewById<EditText>(R.id.editTextText5)
       val edt3 = dialogView.findViewById<EditText>(R.id.editTextText6)

       builder.setView(dialogView)
           .setTitle("Enter details")
           .setPositiveButton("Save") { dialog, which ->
               val name = edt1.text.toString()
               val doctorname = edt2.text.toString()
               val date = edt3.text.toString()

               if (name.isNotBlank() && doctorname.isNotBlank() && date.isNotBlank()) {
                   val patient = Patient(name, doctorname, date) // Provide the correct photoPath
                   CoroutineScope(Dispatchers.IO).launch {
                       repository.insert(patient)
                   }
               }
           }.setNegativeButton("Cancel") { dialog, which ->
               dialog.cancel()
           }
           .show()


   }
}