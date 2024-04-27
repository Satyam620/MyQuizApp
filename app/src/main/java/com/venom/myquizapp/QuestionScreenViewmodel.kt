package com.venom.myquizapp

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel

class QuestionScreenViewmodel : ViewModel() {

    private val questionsList = Constants.getQuestions()
    var score = 0
    val questionListSize = questionsList.size
    var currentPosition = mutableIntStateOf(1)
    var currentProgress = mutableFloatStateOf(.1f)
    var progress = mutableStateOf("1/10")
    var question = mutableStateOf(questionsList[0])
    var selectedButton = mutableIntStateOf(0)

    fun updateQuestion(){
        if(selectedButton.intValue == question.value.correctAnswer){
            score++
        }

        currentPosition.intValue++

        if(currentPosition.intValue <= questionListSize){
            question.value = questionsList[currentPosition.intValue - 1]
            currentProgress.floatValue = currentPosition.intValue.toFloat()/questionListSize.toFloat()
            progress.value = "${currentPosition.intValue}/$questionListSize"
            selectedButton.intValue = 0
        }

    }
}




