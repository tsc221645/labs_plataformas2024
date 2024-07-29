import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MyCustomLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Cyan)
            ) {
                Text("1", color = Color.White, modifier = Modifier.align(Alignment.Center))
            }

        }
        Box(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth()
                .background(Color.Blue)
        ) {
            Text("5", color = Color.White, modifier = Modifier.align(Alignment.Center))
        }
        Row(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Gray)
            ) {
                Text("6", color = Color.White, modifier = Modifier.align(Alignment.Center))
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Gray)
            ) {
                Text("7", color = Color.White, modifier = Modifier.align(Alignment.Center))
            }
        }
        Box(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth()
                .background(Color.Blue)
        ) {
            Text("8", color = Color.White, modifier = Modifier.align(Alignment.Center))
        }
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Gray)
            ) {
                Text("9", color = Color.White, modifier = Modifier.align(Alignment.Center))
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Gray)
            ) {
                Text("10", color = Color.White, modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyCustomLayoutPreview() {
    MaterialTheme {
        Surface {
            MyCustomLayout()
        }
    }
}
