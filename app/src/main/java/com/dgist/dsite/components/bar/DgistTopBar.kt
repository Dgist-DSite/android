package com.dgist.dsite.components.bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dgist.dsite.R
import com.dgist.dsite.components.modifier.dgistClickable

@Composable
fun DgistTopBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            modifier = Modifier.dgistClickable(
                onClick = onClick
            ),
            painter = painterResource(id = R.drawable.ic_left_arrow),
            contentDescription = "뒤로가기 아이콘"
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}