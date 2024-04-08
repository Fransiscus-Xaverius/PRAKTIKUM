package com.example.t5_221116955

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val displayName:String,
    val username:String,
    val password:String
):Parcelable