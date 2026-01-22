package com.example.viikko1.domain

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    val tasks: MutableState<List<Task>> = mutableStateOf(emptyList())

    init {
        tasks.value = mockTasks
    }

    fun addTask(task: Task) {
        tasks.value = addTask(tasks.value, task)
    }

    fun toggleDone(id: Int) {
        tasks.value = toggleDone(tasks.value, id)
    }

    fun removeTask(id: Int) {
        tasks.value = tasks.value.filter { it.id != id }
    }

    fun filterByDone(showDone: Boolean?) {
        tasks.value = filterByDone(tasks.value, showDone)
    }

    fun sortByDueDate(ascending: Boolean = true) {
        tasks.value = sortByDueDate(tasks.value, ascending)
    }
}