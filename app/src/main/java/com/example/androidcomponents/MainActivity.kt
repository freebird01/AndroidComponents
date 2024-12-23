package com.example.androidcomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcomponents.ui.theme.AndroidComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComponentsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Components(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Components(name: String, modifier: Modifier = Modifier) {
    val myBackgroundColor = remember {
        mutableStateOf(Color.Red)
    }

    val myButtonText = remember {
        mutableStateOf("Do Your Magic")
    }

    val myButtonTextColor = remember {
        mutableStateOf(Color.White)
    }

    val myText = remember {
        mutableStateOf("Hello Android!")
    }

    val myTextColor = remember {
        mutableStateOf(Color.Black)
    }

    val myButtonStatus = remember {
        mutableStateOf(true)
    }

    val valueOnTextField = remember {
        mutableStateOf("")
    }

    val userInput = remember {
        mutableStateOf("Result: ")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (myButtonStatus.value) {
            Text(
                text = myText.value,
                color = myTextColor.value,
                fontSize = 24.sp,
                modifier = Modifier
                    .background(color = Color.Red, shape = RoundedCornerShape(10.dp))
                    .padding(10.dp)
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        Button(
            onClick = {
                if (myButtonStatus.value) {
                    myBackgroundColor.value = Color.Black
                    myButtonText.value = "Magic Done"
                    myButtonTextColor.value = Color.Red
                    myText.value = "Hey There :)"
                    myTextColor.value = Color.White
                } else {
                    myBackgroundColor.value = Color.Red
                    myButtonText.value = "Do Your Magic"
                    myButtonTextColor.value = Color.White
                    myText.value = "Hello Android!"
                    myTextColor.value = Color.Black
                }
                myButtonStatus.value = !myButtonStatus.value
                userInput.value = valueOnTextField.value
            },
            modifier = Modifier.size(250.dp, 60.dp),
            colors = ButtonDefaults.buttonColors(myBackgroundColor.value),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, Color.Black)
        ) {
            Text(
                text = myButtonText.value,
                color = myButtonTextColor.value,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.size(20.dp))

        TextField(
            value = valueOnTextField.value,
            onValueChange = {
                valueOnTextField.value = it
            },
            //Focused label
            label = { Text("Enter Your Name", color = Color.White) },
            modifier = Modifier
                .width(300.dp)
                .background(color = Color.Green),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Green,
                focusedIndicatorColor = Color.Yellow,
                unfocusedIndicatorColor = Color.Red,
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Cyan
            ),
//            textStyle = TextStyle(color = Color.White, background = Color.Blue)
            maxLines = 4,
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            visualTransformation = PasswordVisualTransformation()

        )

        Spacer(modifier = Modifier.size(20.dp))

        Text(
            text = userInput.value,
            color = Color.White,
            modifier = Modifier
                .background(color = Color.Red, shape = RoundedCornerShape(10.dp))
                .padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidComponentsTheme {
        Components("Android")
    }
}