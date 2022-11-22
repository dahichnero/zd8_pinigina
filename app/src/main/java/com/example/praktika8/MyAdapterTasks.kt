package com.example.praktika8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val taskList : ArrayList<Tasks>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var mListener : onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position : Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener=listener
    }
    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val titleTextView: TextView =itemView.findViewById(R.id.task_title)
        val dateTextView: TextView = itemView.findViewById(R.id.task_date)
        val timeTextView: TextView=itemView.findViewById(R.id.task_hour)
        val descTextView: TextView=itemView.findViewById(R.id.task_desc)
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.taska,parent,false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=taskList[position]
        holder.titleTextView.text=currentItem.title
        holder.dateTextView.text=currentItem.date
        holder.timeTextView.text=currentItem.time
        holder.descTextView.text=currentItem.description
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}