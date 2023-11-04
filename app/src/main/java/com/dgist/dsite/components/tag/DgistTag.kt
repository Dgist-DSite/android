package com.dgist.dsite.components.tag

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.dgist.dsite.components.theme.DgistTheme


@Composable
fun DgistTag(
    modifier: Modifier,
    shape: Shape = DgistTheme.shape.middle,
    border: BorderStroke = BorderStroke(1.dp, Color(0xFFA3A3A3)),
    content: @Composable () -> Unit
) {
    Surface(
        modifier = Modifier
            .then(modifier),
        shape = shape,
        border = border
    ) {
        Box(
            modifier = Modifier.padding(
                vertical = 3.dp,
                horizontal = 7.dp
            )
        ) {
            content()
        }
    }
}