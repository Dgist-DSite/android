package com.dgist.dsite.components.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

data class DgistColor (
    val White: Color = Color.Unspecified,
    val Gray: Color = Color.Unspecified,
    val DarkGray: Color = Color.Unspecified,
    val Red: Color = Color.Unspecified,

    val Purple80: Color = Color.Unspecified,
    val PurpleGrey80: Color = Color.Unspecified,
    val Pink80: Color = Color.Unspecified,

    val Purple40: Color = Color.Unspecified,
    val PurpleGrey40: Color = Color.Unspecified,
    val Pink40: Color = Color.Unspecified,

    val Black: Color = Color.Unspecified,
    val Black80: Color = Color.Unspecified,
    val Black60: Color = Color.Unspecified,
    val Black40: Color = Color.Unspecified,
    val Black20: Color = Color.Unspecified,

    val SurfaceColor: Color = Color.Unspecified,
    val TimeColor: Color = Color.Unspecified,
)
val DailyDiaryLightColor = DgistColor(
    White = Color(0xFFFFFFFF),
    Gray = Color(0xFFE8E8E8),
    DarkGray = Color(0xCC4F4F4F),
    Red = Color(0xFFFF0D0D),

    Purple80 = Color(0xFFD0BCFF),
    PurpleGrey80 = Color(0xFFCCC2DC) ,
    Pink80 = Color(0xFFEFB8C8),

    Purple40 = Color(0xFF6650a4),
    PurpleGrey40 = Color(0xFF625b71),
    Pink40 = Color(0xFF7D5260),

    Black = Color(0xFF000000),
    Black80 = Color(0xCC000000),
    Black60 = Color(0x99000000),
    Black40 = Color(0x66000000),
    Black20 = Color(0x33000000),
    SurfaceColor = Color(0xFFD0D7DE),
    TimeColor = Color(0xFF656D76)

)

val DailyDiaryDarkColor = DgistColor(
    White = Color(0xFFFFFFFF),
    Gray = Color(0xFFFF0D0D),//Color(0xFFE8E8E8),
    DarkGray = Color(0xCC4F4F4F),
    Red = Color(0xFFFF0D0D),

    Purple80 = Color(0xFFD0BCFF),
    PurpleGrey80 = Color(0xFFCCC2DC),
    Pink80 = Color(0xFFEFB8C8),

    Purple40 = Color(0xFF6650a4),
    PurpleGrey40 = Color(0xFF625b71),
    Pink40 = Color(0xFF7D5260),

    Black = Color(0xFF000000),
    Black80 = Color(0xCC000000),
    Black60 = Color(0x99000000),
    Black40 = Color(0x66000000),
    Black20 = Color(0x33000000),
)

internal val LocalColor = compositionLocalOf { DgistColor() }