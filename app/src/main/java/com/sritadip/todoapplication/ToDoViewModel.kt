package com.sritadip.todoapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ToDoViewModel(private val repository: ToDoRepository) :ViewModel(){

    var toDoList = MutableLiveData<List<Todo>>()

    fun getToDoList() {
        viewModelScope.launch {
            repository.getToDoList().observeForever {
                toDoList.postValue(it)
            }

        }
    }

   /* val toDOLiveData: MutableLiveData<List<Todo>> = MutableLiveData()
    val errorMessage = MutableLiveData<String>()

    fun getToDoList() {


        val response = repository.getToDoList()
        response.enqueue(object :Callback<List<Todo>>{
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                Log.e("view model",response.body().toString())
                toDOLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Log.e("view model","error")
                println("Failed to execute request, ${t.printStackTrace()}")
                Log.e("Error",t.message.toString())
                errorMessage.postValue(t.message)            }

        })
        *//*response.enqueue(object : Callback<List<Todo>> {
            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Log.e("view model","error")
                println("Failed to execute request, ${t.printStackTrace()}")
                Log.e("Error",t.message.toString())
                errorMessage.postValue(t.message)
            }

            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                Log.e("view model",response.body().toString())
                toDOLiveData.postValue(response.body())
            }

        })*//*


    }*/
}