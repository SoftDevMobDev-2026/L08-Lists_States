package com.example.l08_lists_states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CityListDemo() {
    var cities by remember { mutableStateOf(initialCities) }
    var query by rememberSaveable { mutableStateOf("") }
    var sortAscending by rememberSaveable { mutableStateOf(true) }
    var nextId by remember { mutableStateOf(100) }

    val filteredCities = cities
        .filter { city -> city.name.contains(query, ignoreCase = true) }
        .let { list ->
            if (sortAscending) list.sortedBy { it.name }
            else list.sortedByDescending { it.name }
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search city") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { sortAscending = !sortAscending }) {
                Text(if (sortAscending) "Sort Z-A" else "Sort A-Z")
            }

            Button(
                onClick = {
                    cities = cities + City(
                        id = nextId++,
                        name = "Geelong",
                        state = "VIC",
                        population = 280_000
                    )
                }
            ) {
                Text("Add")
            }
        }

        LazyColumn {
            items(
                items = filteredCities,
                key = { city -> city.id }
            ) { city ->
                CityRow(
                    city = city,
                    onClick = { selected ->
                        cities = cities.map { current ->
                            if (current.id == selected.id) {
                                current.copy(visited = !current.visited)
                            } else {
                                current
                            }
                        }
                    }
                )

                Button(
                    onClick = {
                        cities = cities.filterNot { it.id == city.id }
                    }
                ) {
                    Text("Delete ${city.name}")
                }
            }
        }
    }
}
