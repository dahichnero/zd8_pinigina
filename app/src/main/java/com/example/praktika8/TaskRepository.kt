package com.example.praktika8

import androidx.lifecycle.LiveData

class TaskRepository(private  val taskDao: TaskDao) {
    val readAllData: LiveData<List<Tasks>> = taskDao.getAll()
    suspend fun addTask(task: Tasks){
        taskDao.insert(task)
    }
}