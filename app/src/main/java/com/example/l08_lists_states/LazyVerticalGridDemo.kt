package com.example.l08_lists_states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LazyVerticalGridDemo() {

    val cities = listOf(
        City(1, "Melbourne", "VIC", 5_300_000),
        City(2, "Sydney", "NSW", 5_500_000),
        City(3, "Brisbane", "QLD", 2_700_000),
        City(4, "Perth", "WA", 2_300_000),
        City(5, "Adelaide", "SA", 1_400_000),
        City(6, "Hobart", "TAS", 250_000)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Cities",
            modifier = Modifier.padding(bottom = 12.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Adaptive(
                minSize = 160.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = cities,
                key = { it.id }
            ) { city ->
                CityGridCard(city)
            }
        }
    }
}

@Composable
fun CityGridCard(city: City) {
    Card {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(city.name)
            Text(city.state)
            Text("Population: ${city.population}")
        }
    }
}
