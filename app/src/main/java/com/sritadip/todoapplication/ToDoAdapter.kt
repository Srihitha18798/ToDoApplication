package com.sritadip.todoapplication


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sritadip.todoapplication.databinding.ItemViewBinding
import kotlinx.android.synthetic.main.item_view.view.*

class ToDoAdapter : RecyclerView.Adapter<ToDoAdapter.MyViewHolder>() {
    private var toDoList: MutableList<Todo> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemViewBinding.inflate(
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


    class MyViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView1: TextView = itemView.description

    }


    fun addData(list: List<Todo>) {
        val size = this.toDoList.size
        this.toDoList.addAll(list)
        val sizeNew = this.toDoList.size
        notifyItemRangeChanged(size, sizeNew)
    }
}