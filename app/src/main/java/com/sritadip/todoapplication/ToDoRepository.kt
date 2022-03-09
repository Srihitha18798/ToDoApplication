package com.sritadip.todoapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ToDoRepository(private val retroInstance: RetroInstance) {

    private val toDoList = MutableLiveData<List<Todo>>()



    suspend fun fetchToDoList() {
        val response = retroInstance.apiService.getToDOList()
        toDoList.postValue(response)

    }


    suspend fun getToDoList(): LiveData<List<Todo>> {
        fetchToDoList()
        return toDoList
    }

}