package com.adrino.justjetpack.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MusicInfo(
    val musicTitle: String,
    val albumArt: Int
) : Parcelable