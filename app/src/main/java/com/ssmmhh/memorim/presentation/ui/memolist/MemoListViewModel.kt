package com.ssmmhh.memorim.presentation.ui.memolist

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.ssmmhh.memorim.domain.models.Memo
import com.ssmmhh.memorim.repositories.MemoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MemoListViewModel
@Inject constructor(
    private val testString: String,
    private val memoRepository: MemoRepository
) : ViewModel() {


    private val TAG = "MemoListViewModel"

    val memos: Flow<List<Memo>> get() = memoRepository.observeMemos()

    val newMemoTitle = mutableStateOf("")
    val isDoneButtonEnable = mutableStateOf(false)

    fun onNewMemoTitleChange(memoTitle: String) {
        //change done button enable state
        isDoneButtonEnable.value = memoTitle.isNotBlank()
        newMemoTitle.value = memoTitle
    }
}