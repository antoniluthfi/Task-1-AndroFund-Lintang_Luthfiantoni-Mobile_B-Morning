package com.example.tugasandroidfundamental.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val username: String,
    val email: String,
    val phoneNumber: String,
    val password: String
): Parcelable