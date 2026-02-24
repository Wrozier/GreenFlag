package com.example.greenflag.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.greenflag.R   // ← make sure this import is present

// 1. Define the FontFamily using your font resource
val MuseoSansFontFamily = FontFamily(
    Font(R.font.museosans_500, FontWeight.Normal)   // 500 weight treated as regular/medium
    // If you later add bolder/lighter variants (e.g. museosans_700.ttf), include them here:
    // Font(R.font.museosans_700, FontWeight.Bold),
)


val GreenFlagTypography = Typography(

    // Body text (most common for paragraphs, descriptions)
    bodyLarge = TextStyle(
        fontFamily = MuseoSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    // Titles / headings (commonly used in your screens)
    titleLarge = TextStyle(
        fontFamily = MuseoSansFontFamily,
        fontWeight = FontWeight.Normal,   // or .Medium if it feels too light
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    // Small labels (e.g. buttons, captions, error messages)
    labelSmall = TextStyle(
        fontFamily = MuseoSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),

    // Add more styles as needed (examples below – uncomment if you use them)
    /*
    headlineMedium = TextStyle(
        fontFamily = MuseoSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = MuseoSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    */
)