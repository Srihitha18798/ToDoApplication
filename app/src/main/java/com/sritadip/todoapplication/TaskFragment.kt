package com.sritadip.todoapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_task.view.*

class TaskFragment : Fragment() {
    lateinit var viewModel: ToDoViewModel
    private val retroInstance = RetroInstance
    private var adapter: ToDoAdapter? = null
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var view1: View



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view1 = inflater.inflate(R.layout.fragment_task, container, false)
        init()
        return view1;
    }

    private fun init(){
        viewModel = ViewModelProvider(this, ViewModelFactory(ToDoRepository((retroInstance)))).get(ToDoViewModel::class.java)

        attachObserver()

        setupAdapter()
    }
    private fun setupAdapter() {
        adapter = ToDoAdapter()
        view1.rv.adapter = adapter
        linearLayoutManager = LinearLayoutManager(requireContext())
        view1.rv.layoutManager = linearLayoutManager

    }

    private fun attachObserver() {
        viewModel.getToDoList()
            viewModel.toDoList.observeForever {
                if (it != null) {
                    Log.e("data", it.toString())
                    adapter?.addData(it)

                } else {
                    Toast.makeText(requireContext(), "Error getting data", Toast.LENGTH_SHORT)
                        .show()
                    Log.e("fragment","error")
                }
            }

    }


}