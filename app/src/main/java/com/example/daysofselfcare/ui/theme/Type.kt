package com.example.daysofselfcare.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.daysofselfcare.R

val Jost = FontFamily(
    Font(R.font.jost,FontWeight.Normal)
)

val Dosis = FontFamily(
    Font(R.font.dosis_bold,FontWeight.Bold)
)

val Montserrat_Alternates = FontFamily(
    Font(R.font.montserrat_alternates,FontWeight.Normal),
    Font(R.font.montserrat_alternates_italic,FontWeight.Normal, FontStyle.Italic),
    Font(R.font.montserrat_alternates_light, FontWeight.Light)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = Montserrat_Alternates,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 24.sp,
        shadow = Shadow(
            color = Color.Gray,
            offset = Offset(8f, 8f),
            blurRadius = 4f
        )
    ),
    displayMedium = TextStyle(
        fontFamily = Montserrat_Alternates,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Montserrat_Alternates,
        fontWeight = FontWeight.Light,
        fontSize = 18.sp
    )

)