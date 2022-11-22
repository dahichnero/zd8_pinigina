package com.example.praktika8

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tasks :: class], version = 1, exportSchema = false)
abstract class AppDataBase() : RoomDatabase(){
    abstract fun taskDao() : TaskDao
    companion object{
        @Volatile
        private var INSTANCE : AppDataBase?=null
        fun getDatabase(context: Context):AppDataBase{
            val tempInstance= INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "task_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}