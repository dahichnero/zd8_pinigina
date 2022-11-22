package com.example.praktika8


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.praktika8.databinding.ActivityMainBinding

class GeneralActivity : AppCompatActivity() {
    lateinit var newRecyclerView: RecyclerView
    lateinit var newArrayList:LiveData<List<Tasks>>
    lateinit var database: AppDataBase
    lateinit var newList:ArrayList<Tasks>
    var tasks= mutableListOf<Tasks>()
    var i:Int=1
    init {
        while (i<=10){
            val task=Tasks(i,"Abb","10.10.10","12:20","SaleSale")
            tasks.add(task)
            i++
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general)
        newRecyclerView=findViewById(R.id.task_recycler_view)
        newRecyclerView.layoutManager= LinearLayoutManager(this)
        var adapter=MyAdapter(tasks as ArrayList<Tasks>)
        newRecyclerView.adapter=adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent= Intent(this@GeneralActivity,EditTask::class.java)
                intent.putExtra("idlik",tasks[position].uid)
                intent.putExtra("titlik",tasks[position].title)
                intent.putExtra("datelik",tasks[position].date)
                intent.putExtra("timelik",tasks[position].time)
                intent.putExtra("desclik",tasks[position].description)
                startActivity(intent)
            }

        })


    }
    fun adds(view: android.view.View){
        val intent= Intent(this,EditTask::class.java)
        startActivity(intent)
    }
    fun sighup(view: android.view.View){
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}