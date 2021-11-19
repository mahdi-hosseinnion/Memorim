package com.ssmmhh.memorim.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ssmmhh.memorim.domain.models.Memo
import com.ssmmhh.memorim.domain.util.MemoFactory

@Preview
@Composable
private fun PreviewMemoCard() {
    val previewMemo = MemoFactory.createMemo(
        title = "Title",
        description = "description"
    )
    val onClick: (memo: Memo) -> Unit = { }
    MemoCard(memo = previewMemo, onClick = onClick)
}

@Preview
@Composable
private fun PreviewTestMemoCard() {
    val previewMemo = MemoFactory.createMemo(
        title = "Title",
        description = "description"
    )
    val onClick: (memo: Memo) -> Unit = { }
    TestMemoCard(memo = previewMemo, onClick = onClick)
}

@Composable
fun MemoCard(
    memo: Memo,
    onClick: (memo: Memo) -> Unit,
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 12.dp
            )
            .fillMaxWidth()
            .clickable { onClick(memo) },
        elevation = 2.dp,
    ) {
        Column {
            Text(
                text = memo.title,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(8.dp)
            )
            memo.description?.let {
                Text(
                    text = memo.description,

                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(
                            top = 0.dp,
                            start = 8.dp,
                            end = 8.dp,
                            bottom = 8.dp
                        ),
                    style = MaterialTheme.typography.subtitle2
                        .copy(color = Color.Gray)
                )
            }
        }
    }


}

@Composable
fun TestMemoCard(
    memo: Memo,
    onClick: (memo: Memo) -> Unit,
) {
    Column(modifier = Modifier.background(Color.White)) {
        MemoCard(memo = memo, onClick = onClick)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "createdAt: ${memo.createdAt}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "updatedAt: ${memo.updatedAt}")
    }

}