package com.venom.myquizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.venom.myquizapp.ui.RewardScreen
import com.venom.myquizapp.ui.theme.MyQuizAppTheme

class ScoreActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyQuizAppTheme {
                val score = intent.getIntExtra("score", 0)
                val name = intent.getStringExtra("name")
                RewardScreen(score,name)
            }
        }
    }
}

