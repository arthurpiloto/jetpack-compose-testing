package com.example.bmicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicompose.ui.theme.BMIComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMIComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var textState = remember {
        mutableStateOf("")
    }

    var nameText = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.background(color = Color.Blue)
    ) {
        for (x in 1 .. 5) {
            Text(
                text = "Hello $name $x!",
                fontSize = 32.sp,
                color = Color.Red
            )
        }

        Row(
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxWidth()
                .fillMaxHeight(0.25f),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Text(
                    text = "Botão 1",
                    color = Color.White
                )
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(width = 90.dp, height = 90.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(Color.Red),
            ) {
                Text(
                    text = "Botão 2",
                    color = Color.White
                )
            }

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Text(
                    text = "Botão 3",
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 32.dp,
                    bottom = 32.dp,
                    end = 16.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = textState.value,
                    onValueChange = {
                        textState.value = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                TextField(
                    value = nameText.value,
                    onValueChange = {
                        nameText.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 12.dp,
                            bottom = 28.dp
                        )
                )

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Image(painter = painterResource(id = R.drawable.clean_icon), contentDescription = "Cleaning a table icon")
                        Text(text = "Limpar")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BMIComposeTheme {
        Greeting("Android")
    }
}