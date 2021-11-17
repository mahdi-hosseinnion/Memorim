package com.ssmmhh.memorim.presentation.ui.memolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.ssmmhh.memorim.R

class MemoListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            Column(modifier = Modifier.padding(32.dp)) {
                Text("Hey this is the \nMemoList fragment")
                Spacer(modifier = Modifier.padding(32.dp))
                TextButton(onClick = {
                    findNavController().navigate(R.id.action_memoListFragment_to_memoFragment)
                }) {
                    Text("click here to go to memo fragment")
                }
            }
        }
    }


}