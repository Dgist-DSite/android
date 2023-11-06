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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
import com.dgist.dsite.utiles.collectAsSideEffect
import com.dgist.dsite.utiles.isValidHttpsUrl
import com.dgist.dsite.utiles.shortToast

@Composable
fun PostInsertScreen(
    navController: NavController,
    viewModel: PostInsertViewModel = viewModel(),
) {
    val focus = LocalFocusManager.current
    val context = LocalContext.current

    val focusRequester = remember { FocusRequester() }
    val state = viewModel.uiState.collectAsState().value

    var url by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("안드로이드") }
    var content by remember { mutableStateOf("") }

    viewModel.sideEffect.collectAsSideEffect {
        when(it) {
            is PostInsertSideEffect.SuccessCreate -> {
                context.shortToast("등록에 성공하였습니다.")
                navController.popBackStack()
            }
            is PostInsertSideEffect.ToastError -> {
                context.shortToast(it.message)
            }
        }
    }

    Scaffold(
        modifier = Modifier
            .focusRequester(focusRequester),
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .background(DgistTheme.color.Orange)
                    .dgistClickable(
                        rippleEnable = true
                    ) {
                        if (state.loading) {
                            return@dgistClickable
                        }
                        if (category.isBlank()) {
                            context.shortToast("카테고리가 선택되지 않았습니다.")
                            return@dgistClickable
                        }
                        if (url.isBlank()) {
                            context.shortToast("링크가 입력되지 않았습니다.")
                            return@dgistClickable
                        }
                        if (url
                                .isValidHttpsUrl()
                                .not()
                        ) {
                            context.shortToast("유효한 링크가 입력되지 않았습니다.")
                            return@dgistClickable
                        }
                        viewModel.insert(
                            category = category,
                            url = url,
                            content = content
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
                Title2(
                    text = "업로드",
                    textColor = DgistTheme.color.White
                )
            }
        },
        containerColor = DgistTheme.color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .background(DgistTheme.color.White)
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        focus.clearFocus()

                    })
                }
        ) {
            DgistTopBar {
                navController.popBackStack()
            }
            Spacer(modifier = Modifier.height(8.dp))
            BoldBody1(text = "카테고리")
            Spacer(modifier = Modifier.height(4.dp))
            DgistButtonSelectMenu(
                itemList = listOf("안드로이드", "웹", "iOS", "서버", "게임", "임베디드", "창업", "기타"),
                hint = category,
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
                hint = "(선택) 내용을 입력하세요.",
                singleLine = false,
                onValueChange = {
                    content = it
                }
            )

        }
    }
}