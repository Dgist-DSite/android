package com.dgist.dsite.components.select

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.dgist.dsite.R
import com.dgist.dsite.components.theme.Body1
import com.dgist.dsite.components.theme.DgistTheme
import retrofit2.http.Body

@Composable
fun DgistButtonSelectMenu(
    itemList: List<String>,
    modifier: Modifier = Modifier,
    hint: String = "",
    onSelectItemListener: (String) -> Unit
) {
    // 1. DropDownMenu의 펼쳐짐 상태 정의
    var isDropDownMenuExpanded by remember { mutableStateOf(false) }
    var buttonSize by remember { mutableStateOf(Size.Zero) }
    var buttonText by remember { mutableStateOf(hint) }
    val focusRequester = remember { FocusRequester() }
    Column {
        Button(
            modifier = modifier
                .onGloballyPositioned { coordinates ->
                    buttonSize = coordinates.size.toSize()
                }
                .focusRequester(focusRequester),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFBFF), contentColor = DgistTheme.color.Black),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(1.5.dp, color = Color(0xFFC6CFD7)),
            contentPadding = PaddingValues(vertical = 20.dp, horizontal = 20.dp),
            onClick = { isDropDownMenuExpanded = true }
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Body1(
                    modifier = Modifier
                        .align(Alignment.CenterStart),
                    text = buttonText
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    painter = painterResource(id = R.drawable.ic_bottom_arrow),
                    contentDescription = "아래 화살표"
                )
            }

        }

        // 3. DropDownMenu 정의
        DropdownMenu(
            modifier = Modifier
                .width(
                    with(LocalDensity.current) {
                        buttonSize.width.toDp()
                    }
                )
                .heightIn(max = 200.dp)
                .background(DgistTheme.color.White),
            expanded = isDropDownMenuExpanded,
            onDismissRequest = { isDropDownMenuExpanded = false }
        ) {
            itemList.forEachIndexed { index, label ->
                DropdownMenuItem(
                    modifier = Modifier.background(Color(0xFFFFFBFF)),
                    text = {
                        Body1(text = label)
                    },
                    onClick = {
                        buttonText = label
                        onSelectItemListener(label)
                        isDropDownMenuExpanded = false
                    }
                )
            }
        }
    }

}