package com.uvg.ana.ejerciciosclase1208

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var textState by remember { mutableStateOf(TextFieldValue("")) }
    val items = remember { mutableStateListOf<String>() }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (textState.text.isNotEmpty()) {
                    items.add(textState.text)
                    textState = TextFieldValue("")
                }
            }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextField(
                        value = textState,
                        onValueChange = { textState = it },
                        placeholder = { Text("Nuevo elemento") },
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(onClick = { textState = TextFieldValue("") }) {
                        Icon(Icons.Default.Close, contentDescription = "Vaciar campo")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(items) { item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .background(Color.LightGray)
                                .padding(16.dp)
                        ) {
                            Text(text = item, modifier = Modifier.weight(1f))
                            IconButton(onClick = {
                                items.remove(item)
                            }) {
                                Icon(Icons.Default.Delete, contentDescription = "Eliminar elemento")
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
