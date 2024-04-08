package com.example.t5_221116955

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post (
    val id:String,
    val author:String,
    val topic:String,
    val content:String,
    val likes:MutableList<String>,
    var replies:MutableList<Reply>
):Parcelable