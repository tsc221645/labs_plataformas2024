package com.uvg.ana.laboratorio5
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.ana.laboratorio5.ui.theme.Laboratorio5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio5Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    RestaurantView()
                }
            }
        }
    }
}

@Composable
fun RestaurantView() {
    //Detalles del restaurante ------------------------------------------------------------------------
    val context = LocalContext.current
    val restaurantName = "Nacion Sushi"
    val restaurantAddress = "JG44+86P, Cdad. de Guatemala 01015"
    val restaurantHours = "11:00 AM - 10:00 PM"
    val restaurantCoordinates = "14.6374366,-90.508493"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Fecha de cumpleaños --------------------------------------------------------------------------------------------------
        Text(
            text = "Viernes, 2 de Febrero 2024",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        //Posicionamiento de detalles del restaurante --------------------------------------------------------------------------
        Text(
            text = restaurantName,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = restaurantAddress,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = restaurantHours,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            //Accion de boton -> Nombre completo -----------------------------------------------------------------------------------------
            Button(onClick = {
                Toast.makeText(context, "Ana Laura Tschen Moscoso", Toast.LENGTH_SHORT).show()
            }) {
                Text("Iniciar")
            }

            //Accion de boton -> Descarga de WhatsApp ------------------------------------------------------------------------------------
            Button(onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp"))
                context.startActivity(intent)
            }) {
                Text("Descargar")
            }

            // Accion del boton -> View del Google Maps en base a detalles declarados anteriormente para el restaurante -------------------
            IconButton(onClick = {
                val gmmIntentUri = Uri.parse("geo:$restaurantCoordinates?q=$restaurantCoordinates($restaurantName)")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                context.startActivity(mapIntent)
            }) {
                Icon(Icons.Filled.ArrowForward, contentDescription = "Directions")
            }

            //Accion de boton -> Detalles de la comida -------------------------------------------------------------------------------------
            Button(onClick = {
                Toast.makeText(context, "Comida Japonesa\nCaro: QQQ", Toast.LENGTH_SHORT).show()
            }) {
                Text("Detalles")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Laboratorio5Theme {
        RestaurantView()
    }
}
