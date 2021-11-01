package com.ssmmhh.memorim.presentation.ui.memolist

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MemoListViewModel
@Inject constructor(
    private val testString: String
) : ViewModel() {
    private val TAG = "MemoListViewModel"

    init {
        Log.d(TAG, "init: we got: $testString")
    }
}