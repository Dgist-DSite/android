package com.dgist.dsite.ui.feature.post.info

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dgist.dsite.R
import com.dgist.dsite.components.figure.Cricle
import com.dgist.dsite.components.modifier.dgistClickable
import com.dgist.dsite.components.ogtag.DgistOgTag
import com.dgist.dsite.components.tag.DgistTag
import com.dgist.dsite.components.theme.Body1
import com.dgist.dsite.components.theme.Body3
import com.dgist.dsite.utiles.TAG

@Composable
fun PostInfoScreen(
    navController: NavController,
    id: Int
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            modifier = Modifier.dgistClickable {
                Log.d(TAG, "PostInfoScreen: 클릭")
            },
            painter = painterResource(id = R.drawable.ic_left_arrow),
            contentDescription = "뒤로가기 아이콘"
        )
        Spacer(modifier = Modifier.height(24.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Body1(text = "8954sood")
                Spacer(modifier = Modifier.width(8.dp))
                Cricle(
                    modifier = Modifier.size(2.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Body1(
                    text = "2시간 전",
                    textColor = Color(0xFF656D76)
                )
            }
            DgistTag(modifier = Modifier.align(Alignment.CenterEnd)) {
                Body3(text = "안드로이드")
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        DgistOgTag(
            image = painterResource(id = R.drawable.ic_launcher_background),
            title = "개발자들은 대체 글을 어디서나올까...",
            content = "ㅁㅁㅁ",
            url = "velog.com",
        )
        Spacer(modifier = Modifier.height(24.dp))
        Body3(
            modifier = Modifier.fillMaxWidth(),
            text = "일단 이글은 개발자가 기본적으로 알아야하는 상식들에 대해 정리된 게시글이다. 아무래도 어쩌구..저쩌구..\n" +
                "\n" +
                "그래서 나는 이렇게 생각한..."
        )
    }
}