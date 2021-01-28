package com.ashwin.coroutinestest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.test.runBlockingTest
import org.json.JSONObject
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @get:Rule
    val instantTestExecutorRule = InstantTaskExecutorRule()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun subtractTest() = runBlockingTest {
        val viewModel = MainViewModel()

        val actual = viewModel.subtract(5, 2)
        val expected = 3

        assertEquals(expected, actual)
    }

    @Test
    fun subtractOneTest() {
        val testContextProvider = TestContextProvider()
        val viewModel = TestableViewModel(testContextProvider)

        viewModel.subtractOne()
        testContextProvider.testCoroutineDispatcher.advanceUntilIdle()

        val actual = viewModel.count.value
        val expected = -1

        assertEquals(expected, actual)
    }

    @Test
    fun networkResponseTest() {
        val testContextProvider = TestContextProvider()
        val viewModel = NetworkViewModel(testContextProvider)

        viewModel.requestResponse()
        testContextProvider.testCoroutineDispatcher.advanceUntilIdle()

        val res = viewModel.response.value
        val json = JSONObject(res)  // Note: Using JSON requires org.json:json lib as testImplementation
        val actual = json.getString("username")
        val expected = "Bret"

        assertEquals(expected, actual)
    }
}