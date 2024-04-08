package com.example.t5_221116955

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Reply(
    val displayName:String,
    val content:String,
    val likes:MutableList<String>,
    val dislikes:MutableList<String>
):Parcelable