package com.example.androiddevchallenge.domain.entity

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pet(
    val name: String,
    val color: String? = null,
    val sex: String? = null,
    @DrawableRes val image: Int = R.drawable.cat_funny_face
): Parcelable