package com.dgist.dsite.ui.feature.post.insert

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dgist.dsite.R
import com.dgist.dsite.components.bar.DgistTopBar
import com.dgist.dsite.components.figure.Cricle
import com.dgist.dsite.components.modifier.dgistClickable
import com.dgist.dsite.components.ogtag.DgistOgTag
import com.dgist.dsite.components.select.DgistButtonSelectMenu
import com.dgist.dsite.components.tag.DgistTag
import com.dgist.dsite.components.textfield.DgistTextField
import com.dgist.dsite.components.theme.Body1
import com.dgist.dsite.components.theme.Body3
import com.dgist.dsite.components.theme.BoldBody1
import com.dgist.dsite.components.theme.DgistTheme
import com.dgist.dsite.components.theme.Title1
import com.dgist.dsite.components.theme.Title2
import com.dgist.dsite.utiles.TAG

@Composable
fun PostInsertScreen(

) {
    val focus = LocalFocusManager.current

    var url by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .background(DgistTheme.color.Orange)
                    .dgistClickable(
                        rippleEnable = true
                    ) {

                    },
                contentAlignment = Alignment.Center
            ) {
                Title2(
                    text = "업로드",
                    textColor = DgistTheme.color.White
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        focus.clearFocus()

                    })
                }
        ) {
            DgistTopBar {

            }
            Spacer(modifier = Modifier.height(8.dp))
            BoldBody1(text = "카테고리")
            Spacer(modifier = Modifier.height(4.dp))
            DgistButtonSelectMenu(
                itemList = listOf("안드로이드", "웹", "iOS", "서버", "게임", "임베디드", "창업", "기타"),
                hint = "안드로이드",
                onSelectItemListener =  {
                    category = it
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
            BoldBody1(text = "링크")
            Spacer(modifier = Modifier.height(4.dp))
            DgistTextField(
                modifier = Modifier.fillMaxWidth(),
                value = url,
                hint = "ex) https://example.com",
                onValueChange = {
                    url = it
                }
            )

            Spacer(modifier = Modifier.height(24.dp))
            BoldBody1(text = "내용")
            Spacer(modifier = Modifier.height(4.dp))
            DgistTextField(
                modifier = Modifier.fillMaxWidth(),
                value = content,
                singleLine = false,
                onValueChange = {
                    content = it
                }
            )

        }
    }
}