package com.example.l08_lists_states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LazyRowDemo() {

    val categories = listOf(
        "All",
        "VIC",
        "NSW",
        "QLD",
        "WA"
    )

    var selected by rememberSaveable {
        mutableStateOf("All")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Select a category")

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(categories) { category ->
                FilterChip(
                    selected = category == selected,
                    onClick = { selected = category },
                    label = { Text(category) }
                )
            }
        }

        Text(
            text = "Selected: $selected",
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
