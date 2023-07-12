package com.example.daysofselfcare.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SelfCare(
    @StringRes val day: Int,
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val description1: Int,
    @StringRes val description2: Int
)
