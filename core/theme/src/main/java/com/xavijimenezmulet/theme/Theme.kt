package com.xavijimenezmulet.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable


private val DarkColorPalette = darkColorScheme(
    primary = Blue,
    inversePrimary = Blue,
    onPrimary = Black,
    secondary = Red,
    tertiary = RedDark,
    onTertiary = White,
    onSecondary = Black,

    background = BackgroundDark,
    onBackground = BackgroundDark,

    surface = CardDark,
    onSurface = CardDark
)


private val LightColorPalette = lightColorScheme(
    primary = White,
    inversePrimary = Red,
    onPrimary = White,
    secondary = Red,
    tertiary = Red,
    onTertiary = Black,
    onSecondary = Black,

    background = BackgroundLight,
    onBackground = BackgroundLight,

    surface = White,
    onSurface = White
)

val MobileChallengeColors: ColorScheme
    @Composable get() = MaterialTheme.colorScheme

val MobileChallengeShapes: Shapes
    @Composable get() = MaterialTheme.shapes

val MobileChallengeTypography: Typography
    @Composable get() = MaterialTheme.typography

@Composable
fun MobileChallengeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val typography = if (darkTheme) {
        DarkTypography
    } else {
        LightTypography
    }

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}