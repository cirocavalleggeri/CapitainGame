package com.example.capitaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.capitaingame.ui.theme.CapitainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapitainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    capitanGame()
                }
            }
        }
    }
}

@Composable
fun capitanGame() {
    val tesoriAccumulati=remember{ mutableStateOf(0) }
    val direzioneNave= remember { mutableStateOf("North")}
    val stormOrTreasure = remember { mutableStateOf("") }

   Column {
      Text(text = "Tesori Accumulati ${tesoriAccumulati.value}")
       Text(text = "Direzione nave ${direzioneNave.value}")
       Text(text = stormOrTreasure.value)
       Button(onClick = {if(Random.nextBoolean()){
                           tesoriAccumulati.value+=1
                           stormOrTreasure.value="Trovato un tesoro!"

       }else{    stormOrTreasure.value="Trovata una  tempesta"    }
           direzioneNave.value="North"
       }) {
           Text(text = "North")

       }
       Button(onClick = {if(Random.nextBoolean()){
           tesoriAccumulati.value+=1
           stormOrTreasure.value="Trovato un tesoro!"

       }else{    stormOrTreasure.value="Trovata una  tempesta"    }

           direzioneNave.value="South"
       }) {
           Text(text = "South")

       }
       Button(onClick = {if(Random.nextBoolean()){
           tesoriAccumulati.value+=1

           stormOrTreasure.value="Trovato un tesoro!"

       }else{    stormOrTreasure.value="Trovata una  tempesta"    }
           direzioneNave.value="Est"
       }) {
           Text(text = "Est")

       }
       Button(onClick = {if(Random.nextBoolean()){
           tesoriAccumulati.value+=1

           stormOrTreasure.value="Trovato un tesoro!"

       }else{    stormOrTreasure.value="Trovata una  tempesta"    }
           direzioneNave.value="West"

       }) {
           Text(text = "West")

       }
   }
}

@Preview(showBackground = true)
@Composable
fun capitanGamePreview() {
    CapitainGameTheme {
      capitanGame()
    }
}