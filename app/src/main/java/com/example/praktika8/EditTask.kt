package com.example.praktika8


import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.praktika8.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditTask : AppCompatActivity() {
    lateinit var tileE: EditText
    lateinit var dateE: EditText
    lateinit var timeE: EditText
    lateinit var descE: EditText
    lateinit var database: AppDataBase
    //lateinit var binding: ActivityMainBinding
    var idR: Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_task)
        tileE=findViewById(R.id.title_task)
        dateE=findViewById(R.id.date_task)
        timeE=findViewById(R.id.time_task)
        descE=findViewById(R.id.desc_task)
        val bundle: Bundle?=intent.extras
        idR=bundle!!.getInt("idlik")
        val titleR=bundle!!.getString("titlik")
        val dateR=bundle!!.getString("datelik")
        val timeR=bundle!!.getString("timelik")
        val descR=bundle!!.getString("desclik")
        tileE.setText(titleR)
        dateE.setText(dateR)
        timeE.setText(timeR)
        descE.setText(descR)
    }
    suspend fun zap(view: android.view.View){
        val task=Tasks(idR, tileE.text.toString(),dateE.text.toString(),timeE.text.toString(),descE.text.toString())
        database.taskDao().insert(task)
    }
    suspend fun del(view: android.view.View){
        val task=Tasks(idR, tileE.text.toString(),dateE.text.toString(),timeE.text.toString(),descE.text.toString())
        /*task.title=tileE.text
        task.date=dateE.text
        task.time=timeE.text
        task.description=descE.text*/
        database.taskDao().delete(task)
    }
    fun backlist(view: android.view.View){
        val intent= Intent(this,GeneralActivity::class.java)
        startActivity(intent)
    }
}