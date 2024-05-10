package com.erdemserhat.harmonyhaven.util

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.erdemserhat.harmonyhaven.R

val customFontFamilyJunge = FontFamily(
    Font(R.font.junge_regular, FontWeight.Normal),
    Font(R.font.junge_regular, FontWeight.Bold)
)

val customFontKumbhSans = FontFamily(
    Font(R.font.kumbh_sans_medium,FontWeight.Medium),
    Font(R.font.kumbh_sans_light,FontWeight.Light)
)

val DefaultAppFont = FontFamily(
    Font(R.font.inter_regular,FontWeight.Normal),
    Font(R.font.inter_black,FontWeight.Black),
    Font(R.font.inter_bold,FontWeight.Bold),
    Font(R.font.inter_extrabold,FontWeight.ExtraBold),
    Font(R.font.inter_light,FontWeight.Light),
    Font(R.font.inter_medium,FontWeight.Medium),
    Font(R.font.inter_extralight,FontWeight.ExtraLight),
    Font(R.font.inter_semibold,FontWeight.SemiBold),
    Font(R.font.inter_thin, FontWeight.Thin)
)
val customFontInter = FontFamily(
    Font(R.font.inter_bold,FontWeight.Bold),
    Font(R.font.inter_regular,FontWeight.Medium)
)
