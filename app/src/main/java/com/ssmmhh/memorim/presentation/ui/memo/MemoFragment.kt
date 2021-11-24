package com.ssmmhh.memorim.presentation.ui.memo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MemoFragment : Fragment() {

    private val viewModel: MemoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            MainContent()
        }
    }

    @Composable
    private fun MainContent() {
        Scaffold(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            topBar = {
                TopAppBar {
                    IconButton(onClick = { findNavController().navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, "Back to previous screen")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = { onDoneButtonClicked() },
                        enabled = viewModel.isDoneButtonEnable.value
                    ) {
                        Icon(Icons.Filled.Done, "Done")
                    }
                }
            }
        ) {
            //TODO ADD focus change https://stackoverflow.com/questions/66817856/what-is-the-simplest-way-to-set-the-focus-order-in-jetpack-compose/66819665#66819665
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                TextField(
                    value = viewModel.memoTitle.value,
                    onValueChange = { viewModel.onMemoTitleChange(it) },
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(8.dp),
                    textStyle = MaterialTheme.typography.h5,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    label = { Text("Title") },
                )
                TextField(
                    value = viewModel.memoDescription.value,
                    onValueChange = { viewModel.onMemoDescriptionChange(it) },
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .padding(8.dp),
                    textStyle = MaterialTheme.typography.body1,
                    label = { Text("Description") },
                )
            }
        }

    }

    private fun onDoneButtonClicked() {

    }
}