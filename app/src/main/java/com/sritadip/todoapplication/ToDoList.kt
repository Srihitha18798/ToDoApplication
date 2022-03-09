package com.sritadip.todoapplication

import java.util.*
import kotlin.collections.ArrayList

data class ToDoList(val todo:Todo)

data class Todo(
    val id:Int,
    val description:String,
    val scheduledDate:String,
    val status:String
    )
