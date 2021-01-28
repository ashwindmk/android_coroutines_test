package com.ashwin.coroutinestest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class TestableActivity : AppCompatActivity() {
    private lateinit var viewModel: TestableViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testable)

        viewModel = ViewModelProvider(this, TestableViewModelFactory(CoroutineContextProvider())).get(TestableViewModel::class.java)
    }
}