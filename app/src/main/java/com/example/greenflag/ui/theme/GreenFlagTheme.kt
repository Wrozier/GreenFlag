package com.example.greenflag.ui.theme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF4CAF50),         // green_flag
    primaryContainer = Color(0xFF388E3C),
    onPrimary = Color.White,
    background = Color.Black,
    surface = Color(0xFF121212),
    onBackground = Color.White,
    onSurface = Color.White,
    // Add more as needed
)

@Composable
fun GreenFlagTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,   // or use dynamic color if on Android 12+
        typography = Typography,         // define or use default
        content = content
    )
}