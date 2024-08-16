package com.uvg.ana.laboratorio6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.uvg.ana.laboratorio6.ui.theme.ContadorAvanzadoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContadorAvanzadoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContadorAvanzado()
                }
            }
        }
    }
}

@Composable
fun ContadorAvanzado() {
    var count by remember { mutableStateOf(0) }
    var incrementCount by remember { mutableStateOf(0) }
    var decrementCount by remember { mutableStateOf(0) }
    var maxValue by remember { mutableStateOf(0) }
    var minValue by remember { mutableStateOf(0) }
    var totalChanges by remember { mutableStateOf(0) }
    val history = remember { mutableStateListOf<Pair<Int, Boolean>>() }

    fun updateStatistics(newCount: Int) {
        if (newCount > maxValue) maxValue = newCount
        if (newCount < minValue) minValue = newCount
        totalChanges = incrementCount + decrementCount
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Título
        Text(
            text = "Nombre del Usuario",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom =  16.dp)
        )

        // Contador
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Button(onClick = {
                count--
                decrementCount++
                history.add(Pair(count, false))
                updateStatistics(count)
            }) {
                Text("-")
            }
            Text(
                text = count.toString(),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
            Button(onClick = {
                count++
                incrementCount++
                history.add(Pair(count, true))
                updateStatistics(count)
            }) {
                Text("+")
            }
        }

        // Estadísticas
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Incrementos: $incrementCount")
            Text("Decrementos: $decrementCount")
            Text("Valor Máximo: $maxValue")
            Text("Valor Mínimo: $minValue")
            Text("Total de Cambios: $totalChanges")
        }

        // Historial en Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(5),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(history.size) { index ->
                val (value, isIncrement) = history[index]
                Box(
                    modifier = Modifier
                        .background(if (isIncrement) Color.Green else Color.Red)
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = value.toString(),
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)

                    )
                }
            }
        }

        // Botón de Reiniciar
        Button(
            onClick = {
                count = 0
                incrementCount = 0
                decrementCount = 0
                maxValue = 0
                minValue = 0
                totalChanges = 0
                history.clear()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reiniciar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ContadorAvanzadoTheme {
        ContadorAvanzado()
    }
}
