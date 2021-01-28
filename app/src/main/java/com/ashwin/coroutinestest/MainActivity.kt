package com.ashwin.coroutinestest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.count.observe(this, Observer {
            counter_textview.text = it.toString()
        })
    }

    fun addOne(view: View) {
        viewModel.addOne()
    }

    fun subtractOne(view: View) {
        viewModel.subtractOne()
    }

    fun openTestableActivity(view: View) {
        startActivity(Intent(this, TestableActivity::class.java))
    }

    fun openNetworkActivity(view: View) {
        startActivity(Intent(this, NetworkActivity::class.java))
    }
}
