package com.example.praktika8

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao{
    @Query("SELECT * FROM tasks_table")
    fun getAll(): LiveData<List<Tasks>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tasks: Tasks)
    @Update
    suspend fun update(tasks: Tasks)
    @Delete
    suspend fun delete(tasks: Tasks)
    @Query("DELETE FROM tasks_table")
    suspend fun deleteAll()
}
