package com.example.boutonscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.boutonscompose.ui.theme.BoutonsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoutonsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Body()
                }
            }
        }
    }
}

@Composable
fun Body() {

    val list = listOf<String>("Matthieu", "Sylvain", "Marie", "José", "Jérome", "Candy")
    var color by remember { mutableStateOf(Color.Black) }
    var count by remember { mutableStateOf(0) }
    var index by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Salut ${list.get(index)}\nCount: $count", color = color)
        Button(
            shape = RoundedCornerShape(percent = 50),
            //border = BorderStroke(width = 2.dp, color = color),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 2.dp,
                pressedElevation = 0.dp,
            ),
            //enabled = false,
            onClick = {
                color = if (color == Color.Black) {
                    Color.Blue
                } else {
                    Color.Black
                }
            }
        ) {
            Row() {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
                Text("Changer de couleur")
            }
        }
        TextButton(onClick = { count++}) {
            Text("Incrémenter")
        }
        TextButton(
            onClick = { count-- },
            content = {Text("Décrémenter", color = Color.Magenta)})
        IconButton(onClick = { count = 0 }) {
            Icon(imageVector = Icons.Default.Done, contentDescription = null)
        }
        FloatingActionButton(
            contentColor = Color.White,
            onClick = {
                index = (list.indices).random()
            }) {
            Icon(imageVector = Icons.Default.Person, contentDescription = null)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BoutonsComposeTheme {
        Body()
    }
}