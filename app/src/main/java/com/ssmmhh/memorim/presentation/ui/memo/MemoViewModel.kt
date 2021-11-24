package com.ssmmhh.memorim.presentation.ui.memo

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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

    private val _memoTitle = mutableStateOf("")
    val memoTitle: State<String> get() = _memoTitle

    private val _memoDescription = mutableStateOf("")
    val memoDescription: State<String> get() = _memoDescription

    private val _isDoneButtonEnable = mutableStateOf(false)
    val isDoneButtonEnable: State<Boolean> get() = _isDoneButtonEnable


    fun onMemoTitleChange(newMemoTitle: String) {
        //change done button enable state
        _isDoneButtonEnable.value = newMemoTitle.isNotBlank() || memoDescription.value.isNotBlank()
        _memoTitle.value = newMemoTitle
    }

    fun onMemoDescriptionChange(newMemoDescription: String) {
        //change done button enable state
        _isDoneButtonEnable.value = newMemoDescription.isNotBlank() || memoTitle.value.isNotBlank()
        _memoDescription.value = newMemoDescription
    }
}