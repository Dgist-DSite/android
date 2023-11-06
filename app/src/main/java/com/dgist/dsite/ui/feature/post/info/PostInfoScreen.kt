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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.dgist.dsite.utiles.collectAsSideEffect
import com.dgist.dsite.utiles.shortToast

@Composable
fun PostInfoScreen(
    navController: NavController,
    id: Int,
    viewModel: PostInfoViewModel = viewModel(),
) {

    val state = viewModel.uiState.collectAsState().value

    val context = LocalContext.current
    viewModel.sideEffect.collectAsSideEffect {
        when(it) {
            is PostInfoSideEffect.ToastError -> {
                context.shortToast(it.message)
            }
        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.load(id)
    }

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            modifier = Modifier.dgistClickable {
                navController.popBackStack()
            },
            painter = painterResource(id = R.drawable.ic_left_arrow),
            contentDescription = "뒤로가기 아이콘"
        )
        Spacer(modifier = Modifier.height(24.dp))
        if (state.loading.not()) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Body1(text = state.data.userName)
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
                    Body3(text = state.data.category)
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            DgistOgTag(
                image = rememberAsyncImagePainter(model = state.data.image),
                title = state.data.title,
                content = state.data.description,
                url = state.data.url,
            )
            Spacer(modifier = Modifier.height(24.dp))
            Body3(
                modifier = Modifier.fillMaxWidth(),
                text = state.data.content
            )
        }
    }
}