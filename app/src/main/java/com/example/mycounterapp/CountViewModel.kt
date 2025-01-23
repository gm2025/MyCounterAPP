package com.example.mycounterapp

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class CountViewModel():ViewModel() {

    private val _repository: CounterRepository=CounterRepository()
    private val _count = mutableStateOf(_repository.getCounter().count)
    val count: MutableState<Int> = _count

    fun increment(){
        _repository.getCounter().count
        _count.value++
    }

    fun decrement(){
        _repository.getCounter().count
        _count.value--
    }
}