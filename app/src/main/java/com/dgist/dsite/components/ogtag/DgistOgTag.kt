package com.dgist.dsite.components.ogtag

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.dgist.dsite.components.theme.Body4
import com.dgist.dsite.components.theme.Body5
import com.dgist.dsite.components.theme.DgistTheme

@Composable
fun DgistOgTag(
    modifier: Modifier = Modifier,
    image: Painter,
    title: String,
    url: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF6F6F6))
            .clip(DgistTheme.shape.small)
            .then(modifier)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            painter = image,
            contentDescription = "이미지",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Spacer(modifier = Modifier.height(4.dp))
            Body4(text = title)
            Body4(
                text = "여기를 눌러 링크를 확인하세요.",
                textColor = Color(0xFF909090)
            )
            Body5(
                text = url,
                textColor = Color(0xFF878787)
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}