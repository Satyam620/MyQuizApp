package com.venom.myquizapp.ui

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.venom.myquizapp.QuizQuestionsActivity
import com.venom.myquizapp.R
import com.venom.myquizapp.ui.theme.Purple40

@Composable
fun HomeScreen() {
    fun Context.findActivity(): ComponentActivity? = when (this) {
        is ComponentActivity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }
    val context = LocalContext.current
    val name = remember {
        mutableStateOf("")
    }
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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Quiz App!",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.5f)
                    .padding(20.dp),
            ) {
                Text(
                    text = "Welcome",
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Please enter Your Name", color = Color.Gray,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
                OutlinedTextField(
                    value = name.value,
                    onValueChange = { newValue ->
                        name.value = newValue.filter { !it.isDigit() }
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    label = { Text("Name", color = Color.Gray) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                )

                Button(
                    onClick = {
                        if (name.value == "") {
                            Toast.makeText(context, "Please Enter Name", Toast.LENGTH_LONG).show()
                        } else {
                            val intent = Intent(context, QuizQuestionsActivity::class.java)
                                intent.putExtra("name", name.value)
                            startActivity(context, intent,null)
                            context.findActivity()?.finish()
                        }
                    }, modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(), shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Purple40)

                ) {
                    Text(text = "START", color = Color.White)
                }
            }
        }
    }
}
