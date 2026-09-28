package com.example.l08_lists_states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun CounterDemo() {
    var count by remember { mutableIntStateOf(0) }

    Button(onClick = { count++ }) {
        Text("Count: $count")
    }
}

@Composable
fun NameField(
    name: String,
    onNameChange: (String) -> Unit
) {
    OutlinedTextField(
        value = name,
        onValueChange = onNameChange,
        label = { Text("Please Enter some Text") }
    )
}

@Composable
fun StateHoistingDemo() {
    var name by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        NameField(
            name = name,
            onNameChange = { name = it }
        )
        Text("Hello $name")
    }
}
