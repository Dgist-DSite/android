package com.dgist.dsite.ui.feature.post

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.dgist.dsite.R
import com.dgist.dsite.components.modifier.dgistClickable
import com.dgist.dsite.components.ogtag.DgistOgTag
import com.dgist.dsite.components.tag.DgistTag
import com.dgist.dsite.components.theme.Body2
import com.dgist.dsite.components.theme.Body3
import com.dgist.dsite.components.theme.DgistTheme
import com.dgist.dsite.components.theme.RegularBody3
import com.dgist.dsite.remote.response.post.PostResponse
import com.dgist.dsite.ui.root.NavGroup
import com.dgist.dsite.utiles.TAG
import com.dgist.dsite.utiles.collectAsSideEffect
import com.dgist.dsite.utiles.shortToast
import java.time.LocalDateTime

@Composable
fun PostScreen(
    navController: NavController,
    viewModel: PostViewModel = viewModel()
) {
    val category = listOf("안드로이드", "웹", "iOS", "서버", "게임", "임베디드", "창업", "기타")

    val state = viewModel.uiState.collectAsState().value
    val context = LocalContext.current

    var nowCategory by remember { mutableStateOf("") }
    val data = state.data

    viewModel.sideEffect.collectAsSideEffect {
        when(it) {
            is PostSideEffect.ToastError -> {
                context.shortToast(it.message)
            }
        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.load(null)
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.size(70.dp),
                onClick = {
                    navController.navigate(NavGroup.Post.POST_INSERT)
                },
                shape = RoundedCornerShape(28.dp),
                containerColor = DgistTheme.color.White
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_button_flaoting),
                    contentDescription = "floating button"
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
            state = rememberLazyListState()
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Body3(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "필터"
                )
                Spacer(modifier = Modifier.height(2.dp))
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                ) {
                    items(category.size) {
                        if (it != 0) {
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                        PostCategory(tag = category[it], clicked = category[it] == nowCategory) {
                            nowCategory = if (category[it] == nowCategory) {
                                ""
                            } else {
                                category[it]
                            }
                            Log.d(TAG, "PostScreen: 엄엄")
                            viewModel.load(if (nowCategory == "") null else nowCategory)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
            itemsIndexed(
                data
            ) { index, item ->
                if (index != 0) {
                    Spacer(modifier = Modifier.height(16.dp))
                }
                PostBox(item) {
                    navController.navigate(NavGroup.Post.POST_INFO.replace("{id}", it.toString()))
                }
            }
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
private fun PostCategory(
    tag: String,
    clicked: Boolean,
    onClick: () -> Unit,
) {
    val color = if (clicked) DgistTheme.color.Black else Color(0xFFB2B2B2)
    Surface(
        modifier = Modifier.dgistClickable(
            rippleEnable = true,
            onClick = onClick
        ),
        shape = DgistTheme.shape.middle,
        border = BorderStroke(1.dp, color)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 8.dp,
                    horizontal = 10.dp
                )
        ) {
            Body3(
                text = tag,
                textColor = color
            )
        }
    }
}

@Composable
private fun PostBox(
    data: PostResponse,
    onClick: (id: Int) -> Unit
) {
    Surface(
        modifier = Modifier
//            .height(220.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .dgistClickable {
                onClick(data.id)
            },
        shape = DgistTheme.shape.middle,
        border = BorderStroke(1.dp,DgistTheme.color.SurfaceColor)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ){
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.ic_user_image),
                        contentDescription = "유저 아이콘",
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Body2(text = data.userName)
                }
                DgistTag(modifier = Modifier.align(Alignment.CenterEnd)) {
                    RegularBody3(text = data.category)
                }
            }
            Spacer(modifier = Modifier.height(11.dp))
            DgistOgTag(
                image = rememberAsyncImagePainter(model = data.image),
                title = data.title,
                content = data.description,
                url = data.url
            )
            Spacer(modifier = Modifier.height(4.dp))
            RegularBody3(
                text = "2시간 전",
                textColor = Color(0xFF656D76)
            )
        }
    }
}