package com.dgist.dsite.components.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.dgist.dsite.R

val pretendard = FontFamily(
    Font(R.font.pretendard_thin, FontWeight.Thin),
    Font(R.font.pretendard_extra_light, FontWeight.ExtraLight),
    Font(R.font.pretendard_light, FontWeight.Light),
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_extra_bold, FontWeight.ExtraBold),
    Font(R.font.pretendard_black, FontWeight.Black),
)

object DgistTypography {

    @Stable
    val body1 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    )
    @Stable
    val body2 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.1.sp
    )
    @Stable
    val body3 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.1.sp
    )
    @Stable
    val body4 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.1.sp
    )
    @Stable
    val body5 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Medium,
        fontSize = 8.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.1.sp
    )
    @Stable
    val title1 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    )
    @Stable
    val title2 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp
    )

    @Stable
    val title3 = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.1.sp
    )

}

@Composable
fun Body1(
    text: String,
    textColor: Color = DgistTheme.color.Black,
    modifier: Modifier = Modifier,
    maxLines: Int = 15,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        color = textColor,
        modifier = modifier,
        style = DgistTypography.body1,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun BoldBody1(
    text: String,
    textColor: Color = DgistTheme.color.Black,
    modifier: Modifier = Modifier,
    maxLines: Int = 15,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        color = textColor,
        modifier = modifier,
        style = DgistTypography.body1.copy(
            fontWeight = FontWeight.Bold
        ),
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun Body2(
    text: String,
    textColor: Color = DgistTheme.color.Black,
    modifier: Modifier = Modifier,
    maxLines: Int = 15,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        color = textColor,
        modifier = modifier,
        style = DgistTypography.body2,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun BoldBody2(
    text: String,
    textColor: Color = DgistTheme.color.Black,
    modifier: Modifier = Modifier,
    maxLines: Int = 15,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        color = textColor,
        modifier = modifier,
        style = DgistTypography.body2.copy(
            fontWeight = FontWeight.Bold
        ),
        maxLines = maxLines,
        overflow = overflow
    )
}
@Composable
fun Body3(
    text: String,
    textColor: Color = DgistTheme.color.Black,
    modifier: Modifier = Modifier,
    maxLines: Int = 15,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        color = textColor,
        modifier = modifier,
        style = DgistTypography.body3,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun RegularBody3(
    text: String,
    textColor: Color = DgistTheme.color.Black,
    modifier: Modifier = Modifier,
    maxLines: Int = 15,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        color = textColor,
        modifier = modifier,
        style = DgistTypography.body3.copy(
            fontWeight = FontWeight.Normal
        ),
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun Body4(
    text: String,
    textColor: Color = DgistTheme.color.Black,
    modifier: Modifier = Modifier,
    maxLines: Int = 15,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        color = textColor,
        modifier = modifier,
        style = DgistTypography.body4,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun Body5(
    text: String,
    textColor: Color = DgistTheme.color.Black,
    modifier: Modifier = Modifier,
    maxLines: Int = 15,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        color = textColor,
        modifier = modifier,
        style = DgistTypography.body5,
        maxLines = maxLines,
        lineHeight = TextUnit.Unspecified,
        overflow = overflow
    )
}

@Composable
fun SemiBoldBody5(
    text: String,
    textColor: Color = DgistTheme.color.Black,
    modifier: Modifier = Modifier,
    maxLines: Int = 15,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        color = textColor,
        modifier = modifier,
        style = DgistTypography.body5.copy(
            fontWeight = FontWeight.SemiBold
        ),
        maxLines = maxLines,
        lineHeight = TextUnit.Unspecified,
        overflow = overflow
    )
}

@Composable
fun Title1(
    text: String,
    textColor: Color = DgistTheme.color.Black,
    modifier: Modifier = Modifier,
    maxLines: Int = 15,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        color = textColor,
        modifier = modifier,
        style = DgistTypography.title1,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun Title2(
    text: String,
    textColor: Color = DgistTheme.color.Black,
    modifier: Modifier = Modifier,
    maxLines: Int = 15,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = text,
        color = textColor,
        modifier = modifier,
        style = DgistTypography.title2,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
fun Title3(
    text: String,
    textColor: Color = DgistTheme.color.Black,
    modifier: Modifier = Modifier,
    maxLines: Int = 15,
    overflow: TextOverflow = TextOverflow.Clip
){
    Text(
        text = text,
        color = textColor,
        modifier = modifier,
        style = DgistTypography.title3,
        maxLines = maxLines,
        overflow = overflow)
}

val LocalTypography = staticCompositionLocalOf { DgistTypography }