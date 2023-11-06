package com.dgist.dsite.components.ogtag

import android.content.Intent
import android.net.Uri
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.dgist.dsite.components.modifier.dgistClickable
import com.dgist.dsite.components.theme.Body4
import com.dgist.dsite.components.theme.Body5
import com.dgist.dsite.components.theme.DgistTheme

@Composable
fun DgistOgTag(
    modifier: Modifier = Modifier,
    image: Painter,
    title: String,
    content: String,
    url: String
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF6F6F6))
            .clip(DgistTheme.shape.small)
            .then(modifier)
            .dgistClickable(
                rippleEnable = true
            ) {
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                context.startActivity(i)
            }
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
            Body4(
                text = title,
                maxLines = 1
            )
            Body4(
                text = content,
                textColor = Color(0xFF909090),
                maxLines = 1
            )
            Body5(
                text = url,
                textColor = Color(0xFF878787),
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}