package com.dgist.dsite.components.figure

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

@Composable
fun Cricle(
    modifier: Modifier,
    color: Color = Color(0xFFD9D9D9)
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(color)
            .then(modifier)
    )
}