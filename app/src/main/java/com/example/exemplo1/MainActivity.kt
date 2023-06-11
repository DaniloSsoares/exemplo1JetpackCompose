package com.example.exemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Exemplo1Theme {
                Column(Modifier.fillMaxSize()) {
                    escrita()
                    val itemsList = listOf("Item 1", "Item 2", "Item 3")
                    ItemList(items = itemsList)
                    Counter()
                }
            }
        }
    }
}

@Preview
@Composable
fun escrita() {
    Column {
        Text(
            text = "Teste!",
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )
        Text(
            text = "estamos indo ebaaa!",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun Exemplo1Theme(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}

@Composable
fun ItemList(items: List<String>) {
    LazyColumn {
        items(items) { item ->
            Text(text = item)
        }
    }
}

@Preview
@Composable
fun PreviewItemList() {
    val itemsList = listOf("Item 1", "Item 2", "Item 3")
    ItemList(items = itemsList)
}

@Preview
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Button(
        onClick = { count++ },
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Black)
    ) {
        Text(text = "Clique: $count")
    }
}