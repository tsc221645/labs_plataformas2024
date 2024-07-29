package com.uvg.ana.ejerciciosplataformas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uvg.ana.ejerciciosplataformas.ui.theme.EjerciciosPlataformasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjerciciosPlataformasTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    EJercicioFronted()
                }
            }
        }
    }
}


@Composable
fun EJercicioFronted () {
    Column {

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjerciciosPlataformasTheme {
        Surface (modifier = Modifier.fillMaxSize()) {
            EJercicioFronted()
        }
    }
}