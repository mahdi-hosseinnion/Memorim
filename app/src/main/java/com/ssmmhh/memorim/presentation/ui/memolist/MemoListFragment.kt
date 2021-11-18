package com.ssmmhh.memorim.presentation.ui.memolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ssmmhh.memorim.presentation.components.MemoCard
import com.ssmmhh.memorim.presentation.ui.theme.MemorimTheme
import com.ssmmhh.memorim.presentation.ui.theme.Purple200
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MemoListFragment : Fragment() {

    private val viewModel: MemoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            MainCompose()
        }
    }

    @Composable
    private fun MainCompose() {

        /**
         * every time 'viewModel1.memos' value changes 'composeMemos' will change too
         * and every composable that uses 'composeMemos' will recompose
         */
        val composeMemos = viewModel.memos.collectAsState(initial = emptyList()).value

        MemorimTheme {

            // A surface container using the 'background' color from the theme
            val greyBackgroundColor = Color(235, 236, 240)
            Surface(color = greyBackgroundColor) {
                Column {

                    LazyColumn(
                        modifier = Modifier.weight(1f)
                    ) {
                        itemsIndexed(
                            items = composeMemos
                        ) { i, memo ->
                            MemoCard(memo = memo, onClick = {
                                Toast.makeText(
                                    requireContext(),
                                    "Hey you clicked on memo with title: " + it.title,
                                    Toast.LENGTH_SHORT
                                ).show()
                            })
                        }
                    }
                    Card(
                        modifier = Modifier.background(color = Purple200),
                        elevation = 8.dp,
                    ) {

                        Row(
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                                .background(color = Purple200)
                        ) {
                            BasicTextField(
                                value = viewModel.newMemoTitle.value,
                                onValueChange = {
                                    viewModel.onNewMemoTitleChange(it)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .align(Alignment.CenterVertically)
                                    .background(color = Purple200)
                                    .padding(
                                        start = 8.dp,
                                        end = 8.dp,
                                        bottom = 4.dp,
                                        top = 4.dp,
                                    ),
                                textStyle = TextStyle(fontSize = 20.sp),
                                maxLines = 5,
                            )
                            Spacer(modifier = Modifier.padding(4.dp))
                            IconButton(
                                onClick = {
                                    viewModel.insertNewMemo()
                                },
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                                    .background(color = Purple200)
                                    .padding(4.dp),
                                enabled = viewModel.isDoneButtonEnable.value
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Create memo"
                                )
                            }
                            Spacer(modifier = Modifier.padding(4.dp))

                        }
                    }


                }
            }
        }

    }

}