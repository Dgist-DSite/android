package com.dgist.dsite.ui.feature.setting

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dgist.dsite.BuildConfig
import com.dgist.dsite.R
import com.dgist.dsite.components.bar.DgistTopBar
import com.dgist.dsite.components.theme.Body1
import com.dgist.dsite.components.theme.BoldBody1
import com.dgist.dsite.components.theme.DgistTheme


@Composable
fun SettingScreen(
    navController: NavController
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        DgistTopBar {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(8.dp))
        SettingButton(
            title = "개인정보 이용약관"
        ) {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse("https://dsite.vercel.app/policy")
            context.startActivity(i)
        }
        Spacer(modifier = Modifier.height(16.dp))
        SettingButton(
            title = "버전 정보",
            content = BuildConfig.VERSION_NAME,
            iconVisible = false
        ) {

        }

    }
}

@Composable
private fun SettingButton(
    title: String,
    content: String? = null,
    iconVisible: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5F5)),
        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                BoldBody1(
                    text = title,
                    textColor = DgistTheme.color.Black
                )
                if (content != null) {
                    Spacer(modifier = Modifier.width(16.dp))
                    Body1(
                        text = content,
                        textColor = Color(0xFF7C7F83)
                    )
                }
            }
            if (iconVisible) {
                Image(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    painter = painterResource(id = R.drawable.ic_right_arrow),
                    contentDescription = "오른쪽 화살표"
                )
            }
        }
    }
}