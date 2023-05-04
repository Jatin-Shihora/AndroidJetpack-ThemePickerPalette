package com.example.jetpackthemepicker.ui.theme

/**
 * used as a state variable for managing the theme of the app
 * */
data class AppThemeState(
    var darkTheme: Boolean = false,
    var pallet: ColorPalette = ColorPalette.PINK
)