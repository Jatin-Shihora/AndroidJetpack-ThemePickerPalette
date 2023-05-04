package com.example.jetpackthemepicker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// dark palettes
private val DarkPinkColorPalette = darkColorScheme(
    primary = pink200,
    secondary = pink500,
    tertiary = teal200,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)

private val DarkGreenColorPalette = darkColorScheme(
    primary = green200,
    secondary = green700,
    tertiary = teal200,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)

private val DarkPurpleColorPalette = darkColorScheme(
    primary = purple200,
    secondary = purple700,
    tertiary = teal200,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)

private val DarkBlueColorPalette = darkColorScheme(
    primary = blue200,
    secondary = blue700,
    tertiary = teal200,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)

private val DarkOrangeColorPalette = darkColorScheme(
    primary = orange200,
    secondary = orange700,
    tertiary = teal200,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)

private val DarkRedColorPalette = darkColorScheme(
    primary = red200,
    secondary = red500,
    tertiary = teal200,
    surface = Color.Black
)

private val DarkYellowColorPalette = darkColorScheme(
    primary = yellow200,
    secondary = yellow500,
    tertiary = teal200,
    surface = Color.Black
)

private val DarkBrownColorPalette = darkColorScheme(
    primary = brown200,
    secondary = brown500,
    tertiary = teal200,
    surface = Color.Black
)

private val DarkGreyColorPalette = darkColorScheme(
    primary = grey200,
    secondary = grey500,
    tertiary = teal200,
    surface = Color.Black
)

private val DarkIndigoColorPalette = darkColorScheme(
    primary = indigo200,
    secondary = indigo500,
    tertiary = teal200,
    surface = Color.Black
)

// Light pallets
private val LightPinkColorPalette = lightColorScheme(
    primary = pink500,
    secondary = pink700,
    tertiary = teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onTertiary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val LightGreenColorPalette = lightColorScheme(
    primary = green500,
    secondary = green700,
    tertiary = teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onTertiary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val LightPurpleColorPalette = lightColorScheme(
    primary = purple500,
    secondary = purple700,
    tertiary = teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onTertiary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val LightBlueColorPalette = lightColorScheme(
    primary = blue500,
    secondary = blue700,
    tertiary = teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onTertiary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val LightOrangeColorPalette = lightColorScheme(
    primary = orange500,
    secondary = orange700,
    tertiary = teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onTertiary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val LightRedColorPalette = lightColorScheme(
    primary = red500,
    secondary = red700,
    tertiary = teal200,
    surface = Color.White
)

private val LightYellowColorPalette = lightColorScheme(
    primary = yellow500,
    secondary = yellow700,
    tertiary = teal200,
    surface = Color.White
)

private val LightBrownColorPalette = lightColorScheme(
    primary = brown500,
    secondary = brown700,
    tertiary = teal200,
    surface = Color.White
)

private val LightGreyColorPalette = lightColorScheme(
    primary = grey500,
    secondary = grey700,
    tertiary = teal200,
    surface = Color.White
)

private val LightIndigoColorPalette = lightColorScheme(
    primary = indigo500,
    secondary = indigo700,
    tertiary = teal200,
    surface = Color.White
)

enum class ColorPalette {
    PINK, PURPLE, GREEN, ORANGE, BLUE, RED, INDIGO, BROWN, GREY
}

@Composable
fun ComposeCookBookTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colorPalette: ColorPalette = ColorPalette.GREEN,
    content: @Composable() () -> Unit
) {

    val colors = colorPalette.getMaterialColors(darkTheme)

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun BaseView(
    appThemeState: AppThemeState,
    systemUiController: SystemUiController?,
    content: @Composable () -> Unit
) {

    val color = appThemeState.pallet.getMaterialColor()

    systemUiController?.setStatusBarColor(color = color, darkIcons = appThemeState.darkTheme)
    ComposeCookBookTheme(darkTheme = appThemeState.darkTheme, colorPalette = appThemeState.pallet) {
        content()
    }
}

fun ColorPalette.getMaterialColors(darkTheme: Boolean): ColorScheme {
    return when (this) {
        ColorPalette.GREEN -> if (darkTheme) DarkGreenColorPalette else LightGreenColorPalette
        ColorPalette.PURPLE -> if (darkTheme) DarkPurpleColorPalette else LightPurpleColorPalette
        ColorPalette.ORANGE -> if (darkTheme) DarkOrangeColorPalette else LightOrangeColorPalette
        ColorPalette.BLUE -> if (darkTheme) DarkBlueColorPalette else LightBlueColorPalette
        ColorPalette.RED -> if (darkTheme) DarkRedColorPalette else LightRedColorPalette
        ColorPalette.PINK -> if (darkTheme) DarkPinkColorPalette else LightPinkColorPalette
        ColorPalette.INDIGO -> if (darkTheme) DarkIndigoColorPalette else LightIndigoColorPalette
        ColorPalette.BROWN -> if (darkTheme) DarkBrownColorPalette else LightBrownColorPalette
        ColorPalette.GREY -> if (darkTheme) DarkGreyColorPalette else LightGreyColorPalette
    }
}

fun ColorPalette.getMaterialColor(): Color {
    return when (this) {
        ColorPalette.GREEN -> green700
        ColorPalette.BLUE -> blue700
        ColorPalette.ORANGE -> orange700
        ColorPalette.PURPLE -> purple700
        ColorPalette.RED -> red700
        ColorPalette.PINK -> pink700
        ColorPalette.INDIGO -> indigo700
        ColorPalette.BROWN -> brown700
        ColorPalette.GREY -> grey700
    }
}