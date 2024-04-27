package com.venom.myquizapp.ui.theme

import android.content.res.Resources.Theme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MyQuizAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        typography = Typography,
        content = content
    )
}