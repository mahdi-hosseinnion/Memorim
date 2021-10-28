package com.ssmmhh.memorim.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Memo(
    val id: Int,
    val title: String,
    val description: String?
) : Parcelable
