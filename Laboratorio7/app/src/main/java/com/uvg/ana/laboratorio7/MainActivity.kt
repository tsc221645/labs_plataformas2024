package com.uvg.ana.laboratorio7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Textsms
import androidx.compose.material.icons.filled.ThumbUp
import com.uvg.ana.laboratorio7.ui.theme.Laboratorio7Theme
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio7Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContent()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    val notifications = generateFakeNotifications()
    var selectedFilter by remember { mutableStateOf<NotificationType?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Notificaciones")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .padding(vertical = 8.dp)

        ) {
            Text(
                text = "Tipos de Notificaciones",
                modifier = Modifier.padding(bottom = 2.dp)
            )
            Row(
                modifier = Modifier
                    .padding(vertical = 2.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            )  {
                UsefulChips("Informativas", NotificationType.NEW_POST, selectedFilter) { type ->
                    selectedFilter = type
                }
                UsefulChips("Capacitaciones", NotificationType.NEW_MESSAGE, selectedFilter) { type ->
                    selectedFilter = type
                }

            }

            Box(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                    //.padding(top = 16.dp)
                    .wrapContentHeight(align = Alignment.Top)
                    .background(Color(0xFFEFEFEF))
            ) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                ) {
                    items(notifications.filter {
                        selectedFilter == null || it.type == selectedFilter
                    }) { notification ->
                        NotificationCard(notification)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsefulChips(label: String, filterType: NotificationType?, selectedFilter: NotificationType?, onFilterChange: (NotificationType?) -> Unit) {
    val isSelected = selectedFilter == filterType
    FilterChip(
        onClick = { onFilterChange(if (isSelected) null else filterType) },
        label = {
            Text(label)
        },
        selected = isSelected,
        leadingIcon = if (isSelected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}

@Composable
fun NotificationCard(notification: Notification) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f)
                .padding(16.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(48.dp)

                    .background(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                        shape = CircleShape
                    ),

                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = when (notification.type) {
                        NotificationType.NEW_POST -> Icons.Default.Notifications
                        NotificationType.NEW_MESSAGE -> Icons.Default.CalendarToday
                        NotificationType.NEW_LIKE -> Icons.Default.ThumbUp
                        else -> Icons.Default.Notifications
                    },
                    contentDescription = null,
                    tint = when (notification.type) {
                        NotificationType.NEW_POST -> MaterialTheme.colorScheme.primary
                        NotificationType.NEW_MESSAGE -> MaterialTheme.colorScheme.secondary
                        NotificationType.NEW_LIKE -> MaterialTheme.colorScheme.secondary
                        else -> MaterialTheme.colorScheme.onSurface
                    },
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = notification.title,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = SimpleDateFormat("dd MMM • h:mm a", Locale.getDefault()).format(notification.sendAt),
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                        fontSize = 10.sp
                    )
                }

                Text(
                    text = notification.body,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppContentPreview() {
    Laboratorio7Theme {
        AppContent()
    }
}
