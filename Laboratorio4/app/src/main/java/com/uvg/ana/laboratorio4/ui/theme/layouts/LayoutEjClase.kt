package com.uvg.ana.laboratorio4.ui.theme.layouts

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.ana.laboratorio4.ui.theme.Laboratorio4Theme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutEjClase() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cultivos") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                )
            )
        }
    ) {
        CropList()
    }
}

@Composable
fun CropList() {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(crops) { crop ->
            CropItem(crop)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CropItem(crop: Crop) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            // Reemplazado con un Box en lugar de Image
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.Gray) // Color de fondo en lugar de imagen
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = crop.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = crop.subtitle,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.width(16.dp)) // Añadido para separar el botón del texto
            Button(
                onClick = { /* Handle button click */ },
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Explorar")
            }
        }
    }
}

data class Crop(val title: String, val subtitle: String)

val crops = listOf(
    Crop("Arroz", "Una altitud y un cultivo"),
    Crop("Camote", "Una altitud y 2 cultivos"),
    Crop("Frijol", "2 altitudes y 15 cultivos")
)

@Preview(showBackground = true)
@Composable
fun CartaPreview() {
    Laboratorio4Theme {
        Surface {
            LayoutEjClase()
        }
    }
}
