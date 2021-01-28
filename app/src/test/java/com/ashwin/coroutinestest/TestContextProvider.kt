package com.ashwin.coroutinestest

import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlin.coroutines.CoroutineContext

class TestContextProvider: CoroutineContextProvider() {
    val testCoroutineDispatcher = TestCoroutineDispatcher()
    override val Main: CoroutineContext = testCoroutineDispatcher
    override val IO: CoroutineContext = testCoroutineDispatcher
}
