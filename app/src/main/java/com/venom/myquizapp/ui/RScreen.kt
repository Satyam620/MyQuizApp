package com.venom.myquizapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.venom.myquizapp.R
import kotlin.system.exitProcess

@Composable
fun RewardScreen(score: Int, name: String?) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hey Congratulations",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                fontSize = 30.sp,
                color = Color.White,
                minLines = 2
            )
            Text(
                text = "$name",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp,
                color = Color.White
            )
            Image(
                painter = painterResource(id = R.drawable.ic_trophy),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = "Your Score is $score/10",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 30.sp,
                color = Color.White
            )

            Button(onClick = {
                exitProcess(0)

            }, colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
                Text(text = "Exit", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

@Preview
@Composable
fun RewardScreenPreview() {
    RewardScreen(score = 10, name = "Venom")
}

