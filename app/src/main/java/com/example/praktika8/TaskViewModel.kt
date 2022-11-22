package com.example.praktika8

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel: ViewModel() {
    /*private val readAllData: LiveData<List<Tasks>>
    private val repository: TaskRepository
    init {
        val taskDao=AppDataBase.getDatabase(application).taskDao()
        repository= TaskRepository(taskDao)
        readAllData=repository.readAllData
    }
    fun addUser(task: Tasks){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTask(task)
        }
    }*/
    val tasks= mutableListOf<Tasks>()
    var i:Int=1
    init {
        while (i<=10){
            val task=Tasks(i,"Abb","10.10.10","12:20","SaleSale")
            tasks.add(task)
            i++
        }
    }
}