package com.sritadip.todoapplication


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sritadip.todoapplication.databinding.PendingItemViewBinding
import kotlinx.android.synthetic.main.pending_item_view.view.*

class ToDoAdapter : RecyclerView.Adapter<ToDoAdapter.MyViewHolder>() {
    private var toDoList: MutableList<Todo> = arrayListOf()
    private val pendingList:MutableList<Todo> = arrayListOf()
    private val completedList:MutableList<Todo> = arrayListOf()

    private fun init(){


        for(item in toDoList){
            if(item.status=="PENDING"){
                pendingList.add(item)
            }
            else{
                completedList.add(item)
            }
        }

        Log.e("pending list",pendingList.toString())
        Log.e("completed list",completedList.toString())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            PendingItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem: Todo = toDoList[position]
        holder.binding.description.text=currentItem.description


    }


    class MyViewHolder(val binding: PendingItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView1: TextView = itemView.description

    }


    fun addData(list: List<Todo>) {
        val size = this.toDoList.size
        this.toDoList.addAll(list)
        init()
        val sizeNew = this.toDoList.size
        notifyItemRangeChanged(size, sizeNew)
    }
}