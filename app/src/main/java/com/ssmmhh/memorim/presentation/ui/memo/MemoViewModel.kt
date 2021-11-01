package com.ssmmhh.memorim.presentation.ui.memo

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ssmmhh.memorim.repositories.MemoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MemoViewModel
@Inject constructor(
    private val testString: String,
    private val memoRepository: MemoRepository
) : ViewModel() {

    private val TAG = "MemoViewModel"

    init {
        Log.d(TAG, "init: i have repository: $memoRepository")
    }
}