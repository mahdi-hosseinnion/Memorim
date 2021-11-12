package com.ssmmhh.memorim.presentation.ui.memolist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssmmhh.memorim.domain.models.Memo
import com.ssmmhh.memorim.domain.util.MemoFactory
import com.ssmmhh.memorim.repositories.MemoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MemoListViewModel
@Inject constructor(
    private val testString: String,
    private val memoRepository: MemoRepository
) : ViewModel() {
    private val TAG = "MemoListViewModel"

    val memos: Flow<List<Memo>> get() = memoRepository.observeMemos()

}