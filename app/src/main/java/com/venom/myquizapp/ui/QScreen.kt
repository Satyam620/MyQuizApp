package com.venom.myquizapp.ui

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.venom.myquizapp.QuestionScreenViewmodel
import com.venom.myquizapp.ScoreActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionScreen(viewmodel: QuestionScreenViewmodel,name:String?) {
    val context = LocalContext.current
    fun Context.findActivity(): ComponentActivity? = when (this) {
        is ComponentActivity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White,
        ), title = { Text(text = "Quiz App") }
        )
        Text(
            text = viewmodel.question.value.question,
            modifier = Modifier.padding(30.dp),
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(id = viewmodel.question.value.image),
            contentDescription = null, // Optional content description
            contentScale = ContentScale.FillBounds, // Scale the image to fill the bounds
            modifier = Modifier
                .height(200.dp)
                .width(300.dp),// Match the parent size
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LinearProgressIndicator(
                progress = viewmodel.currentProgress.floatValue,
                modifier = Modifier.fillMaxWidth(.7F)
            )
            Text(text = viewmodel.progress.value)
        }
        Spacer(modifier = Modifier.padding(20.dp))
        OutlinedButton(
            onClick = {
                viewmodel.selectedButton.intValue = 1
            },
            colors = if (viewmodel.selectedButton.intValue == 1) {
                ButtonDefaults.outlinedButtonColors(containerColor = Color.Green)
            } else {
                ButtonDefaults.outlinedButtonColors()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Text(
                text = viewmodel.question.value.optionOne,
                color = MaterialTheme.colorScheme.primary
            )
        }
        OutlinedButton(
            onClick = {
                viewmodel.selectedButton.intValue = 2
            },
            colors = if (viewmodel.selectedButton.intValue == 2) {
                ButtonDefaults.outlinedButtonColors(containerColor = Color.Green)
            } else {
                ButtonDefaults.outlinedButtonColors()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Text(
                text = viewmodel.question.value.optionTwo,
                color = MaterialTheme.colorScheme.primary
            )
        }
        OutlinedButton(
            onClick = { viewmodel.selectedButton.intValue = 3 },
            colors = if (viewmodel.selectedButton.intValue == 3) {
                ButtonDefaults.outlinedButtonColors(containerColor = Color.Green)
            } else {
                ButtonDefaults.outlinedButtonColors()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Text(
                text = viewmodel.question.value.optionThree,
                color = MaterialTheme.colorScheme.primary
            )
        }
        OutlinedButton(
            onClick = { viewmodel.selectedButton.intValue = 4 },
            colors = if (viewmodel.selectedButton.intValue == 4) {
                ButtonDefaults.outlinedButtonColors(containerColor = Color.Green)
            } else {
                ButtonDefaults.outlinedButtonColors()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Text(
                text = viewmodel.question.value.optionFour,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Button(
            onClick = {
                viewmodel.updateQuestion()
                if (viewmodel.currentPosition.intValue > viewmodel.questionListSize) {
                    val intent = Intent(context, ScoreActivity::class.java)
                    intent.putExtra("score", viewmodel.score)
                    intent.putExtra("name", name)
                    ContextCompat.startActivity(context, intent, null)
                    context.findActivity()?.finish()
                }
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Text(text = if (viewmodel.currentPosition.intValue == viewmodel.questionListSize) "Finish" else "Next")
        }
    }
}

