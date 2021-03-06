package com.ashwin.coroutinestest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    private val _count: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val count: LiveData<Int> = _count

    fun addOne() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(5000)
            _count.postValue(_count.value?.plus(1))
        }
    }

    fun subtractOne() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = subtract(_count.value, 1)
            _count.postValue(result)
        }
    }

    suspend fun subtract(n: Int?, i: Int): Int? {
        delay(5000)
        return n?.minus(i)
    }
}
