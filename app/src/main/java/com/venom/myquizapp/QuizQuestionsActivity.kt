package com.venom.myquizapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.venom.myquizapp.ui.QuestionScreen
import com.venom.myquizapp.ui.theme.MyQuizAppTheme

class QuizQuestionsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = false
            )

            val viewmodel = QuestionScreenViewmodel()
            MyQuizAppTheme {
                QuestionScreen(viewmodel)
            }
        }
    }
}

