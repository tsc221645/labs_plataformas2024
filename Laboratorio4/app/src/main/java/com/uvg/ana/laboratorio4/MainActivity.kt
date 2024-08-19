package com.uvg.ana.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    UVGLayout()
                }
            }
        }
    }
}

val DarkGreen = Color(0xFF058305)

@Composable
fun UVGLayout() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(10.dp, DarkGreen)
            .background(Color.White)
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logouvg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.1f,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Universidad del Valle\n de Guatemala",
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Programación de plataformas\nmóviles, Sección 30",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row {
                Text(
                    text = "INTEGRANTES\n",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Column {
                    Text(text = "       Ana Laura Tschen")
                    Text(text = "       Sebastian Garcia")
                    Text(text = "       Fernando Rueda")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text(
                    text = "CATEDRÁTICO\n",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "       Juan Carlos Durini")
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Ana Laura Tschen\n221645",
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UVGLayoutPreview() {
    MaterialTheme {
        Surface {
            UVGLayout()
        }
    }
}
