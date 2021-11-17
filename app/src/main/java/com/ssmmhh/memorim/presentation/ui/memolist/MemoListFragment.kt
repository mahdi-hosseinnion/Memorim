package com.ssmmhh.memorim.presentation.ui.memolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ssmmhh.memorim.presentation.components.MemoCard
import com.ssmmhh.memorim.presentation.ui.theme.MemorimTheme
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
                    Row(
                        modifier = Modifier
                            .height(64.dp)
                            .fillMaxWidth()
                            .padding(4.dp)
                    ) {
                        TextField(
                            value = "hey im text field", onValueChange = {},
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.padding(4.dp))
                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
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