package com.dgist.dsite.components.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun DgistTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    typography: DgistTypography = DgistTheme.typography,
    shape: DgistShape = DgistTheme.shape,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DailyDiaryDarkColor
        else -> DailyDiaryLightColor
    }
    CompositionLocalProvider(
        LocalColor provides colorScheme,
        LocalTypography provides typography,
        LocalShape provides shape
    ) {
        content()
    }
}

object DgistTheme {
    val color: DgistColor
        @Composable
        @ReadOnlyComposable
        get() = LocalColor.current
    val typography: DgistTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
    val shape: DgistShape
        @Composable
        @ReadOnlyComposable
        get() = LocalShape.current
}