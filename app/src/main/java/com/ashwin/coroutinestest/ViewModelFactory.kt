package com.ashwin.coroutinestest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * This factory is required so that we can mock CoroutineContext by overriding CoroutineContextProvider in our unit tests.
 */
class TestableViewModelFactory(private val contextProvider: CoroutineContextProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TestableViewModel(contextProvider) as T
    }
}

class NetworkViewModelFactory(private val contextProvider: CoroutineContextProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NetworkViewModel(contextProvider) as T
    }
}
