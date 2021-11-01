package com.ssmmhh.memorim.presentation.ui.memolist

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ssmmhh.memorim.repositories.MemoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MemoListViewModel
@Inject constructor(
    private val testString: String,
    private val memoRepository: MemoRepository
) : ViewModel() {
    private val TAG = "MemoListViewModel"

    init {
        Log.d(TAG, "init: i have repository: $memoRepository")
    }
}