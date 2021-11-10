package com.ssmmhh.memorim.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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
            val composeMemos = viewModel1.memos.value
            Log.d(
                TAG,
                "onCreate: composeMemos: -------------------------------------- size is ${composeMemos.size}"
            )

            for (item in composeMemos) {
                Log.d(TAG, "onCreate: item: $item")
            }

            MemorimTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("whats up?")
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