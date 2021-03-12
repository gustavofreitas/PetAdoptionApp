package com.example.androiddevchallenge.domain.entity

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.androiddevchallenge.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pet(
    val name: String,
    val pedigree: String,
    val color: String? = null,
    val behaviour: String? = null,
    val caretaker: String? = null,
    val contact: String? = null,
    @StringRes val sex: Int,
    @DrawableRes val image: Int = R.drawable.cat_funny_face
): Parcelable