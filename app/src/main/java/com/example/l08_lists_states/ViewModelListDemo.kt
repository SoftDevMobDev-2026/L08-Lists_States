package com.example.l08_lists_states

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ViewModelListDemo(viewModel: CityViewModel) {
    val cities by viewModel.cities.collectAsStateWithLifecycle()

    LazyColumn {
        items(cities,
            key = { it.id }) { city ->
            CityRow(
                city = city,
                onClick = { viewModel.toggleVisited(it.id) }
            )

            Button(onClick = { viewModel.delete(city.id) }) {
                Text("Delete ${city.name}")
            }
        }
    }
}
