package com.ssmmhh.memorim.presentation.ui.memo

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MemoViewModel
@Inject constructor(
    private val testString: String

) : ViewModel() {

    private val TAG = "MemoViewModel"

    init {
        Log.d(TAG, "init: we got: $testString")
    }
}