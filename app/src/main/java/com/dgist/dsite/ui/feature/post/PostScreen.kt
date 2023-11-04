package com.dgist.dsite.ui.feature.post

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dgist.dsite.R
import com.dgist.dsite.components.theme.Body2
import com.dgist.dsite.components.theme.Body3
import com.dgist.dsite.components.theme.Body4
import com.dgist.dsite.components.theme.Body5
import com.dgist.dsite.components.theme.SemiBoldBody5
import com.dgist.dsite.components.theme.DgistTheme
import com.dgist.dsite.components.theme.RegularBody3
import com.dgist.dsite.ui.root.NavGroup
import java.time.LocalDateTime

@Composable
fun PostScreen(
    navController: NavController
) { 
    val data = mutableListOf<PostData>()
    for (i in 1..30) {
        data.add(
            PostData(
                name = "테스트 $i",
                thumbnail = "히히",
                tag = "안드로이드",
                time = LocalDateTime.now()
            )
        )
    }
    LazyColumn(
        state = rememberLazyListState()
    ) {
        itemsIndexed(
            data
        ) { index, item ->
            if (index != 0) {
                Spacer(modifier = Modifier.height(25.dp))
            }
            PostBox(item)
        }
    }
}

data class PostData(
    val name: String,
    val thumbnail: String,
    val tag: String,
    val time: LocalDateTime
)

@Composable
private fun PostBox(
    data: PostData
) {
    Surface(
        modifier = Modifier
//            .height(220.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = DgistTheme.shape.middle,
        border = BorderStroke(1.dp,DgistTheme.color.SurfaceColor)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ){
            Row {
                Image(
                    modifier = Modifier
                        .padding(vertical = 3.dp)
                        .size(35.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "앱 아이콘",
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    SemiBoldBody5(text = "안드로이드")
                    Body2(text = "8954sood")
                    RegularBody3(text = "2시간 전")
                }
            }
            Spacer(modifier = Modifier.height(11.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF6F6F6))
                    .clip(DgistTheme.shape.small)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(104.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "이미지",
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Body4(text = "개발자들은 대체 글을 어디서 나올까...")
                    Body4(
                        text = "여기를 눌러 링크를 확인하세요.",
                        textColor = Color(0xFF909090)
                    )
                    Body5(
                        text = "velog.com",
                        textColor = Color(0xFF878787)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}