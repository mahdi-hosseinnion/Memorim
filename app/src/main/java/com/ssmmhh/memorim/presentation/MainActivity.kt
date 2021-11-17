package com.ssmmhh.memorim.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ssmmhh.memorim.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
