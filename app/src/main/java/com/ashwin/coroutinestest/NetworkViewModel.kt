package com.ashwin.coroutinestest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NetworkViewModel(contextProvider: CoroutineContextProvider): ViewModel() {
    val ioContext: CoroutineContext = (contextProvider.IO)

    val URL = "https://jsonplaceholder.typicode.com/users/1"

    private val _response = MutableLiveData<String>("")
    val response: LiveData<String> = _response

    fun requestResponse() {
        viewModelScope.launch(ioContext) {
            val res = getResponse(URL)
            _response.postValue(res)
        }
    }
}
