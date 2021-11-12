package com.ssmmhh.memorim.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ssmmhh.memorim.presentation.components.MemoCard
import com.ssmmhh.memorim.presentation.ui.memo.MemoViewModel
import com.ssmmhh.memorim.presentation.ui.memolist.MemoListViewModel
import com.ssmmhh.memorim.presentation.ui.theme.MemorimTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    private val viewModel1: MemoListViewModel by viewModels()
    private val viewModel2: MemoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            /**
             * every time 'viewModel1.memos' value changes 'composeMemos' while change too
             * and every composable that uses 'composeMemos' will recompose
             */
            val composeMemos = viewModel1.memos.collectAsState(initial = emptyList()).value

            MemorimTheme {
                // A surface container using the 'background' color from the theme
                val greyBackgroundColor = Color(235, 236, 240)
                Surface(color =greyBackgroundColor ) {
                    LazyColumn {
                        itemsIndexed(
                            items = composeMemos
                        ) { i, memo ->
                            MemoCard(memo = memo, onClick = {
                                Toast.makeText(
                                    baseContext,
                                    "Hey you clicked on memo with title: " + it.title,
                                    Toast.LENGTH_SHORT
                                ).show()
                            })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MemorimTheme {
        Greeting("Android")
    }
}