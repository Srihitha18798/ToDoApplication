package com.sritadip.todoapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: ToDoRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(ToDoViewModel::class.java)){
            ToDoViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("viewmodel not found")
        }
    }

}