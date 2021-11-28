package com.ssmmhh.memorim.presentation.ui.memo

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssmmhh.memorim.domain.util.MemoFactory
import com.ssmmhh.memorim.repositories.MemoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    private val _didTheNewMemoInsert = MutableLiveData(false)
    val didTheNewMemoInsert: LiveData<Boolean> get() = _didTheNewMemoInsert

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

    fun onDoneButtonClicked() {
        //disable the button so user cannot insert same memo tow times
        _isDoneButtonEnable.value = false
        //insert new memo
        val memo = MemoFactory.createMemo(
            title = memoTitle.value,
            description = memoDescription.value
        )
        viewModelScope.launch(IO) {
            //insert into database
            memoRepository.insertMemo(memo = memo)
            //notify the fragment that memo have been inserted
            withContext(Main) {
                _didTheNewMemoInsert.value = true
            }

        }
    }
}