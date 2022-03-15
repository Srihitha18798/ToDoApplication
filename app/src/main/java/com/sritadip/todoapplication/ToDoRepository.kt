package com.sritadip.todoapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ToDoRepository(private val retroInstance: RetroInstance) {

    private val toDoList = MutableLiveData<List<Todo>>()



    private suspend fun fetchToDoList() {
        val response = retroInstance.apiService.getToDOList()
        toDoList.postValue(response)

    }


    suspend fun getToDoList(): LiveData<List<Todo>> {
        fetchToDoList()
        return toDoList
    }

}