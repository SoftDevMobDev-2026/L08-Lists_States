package com.example.l08_lists_states

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CityRow(
    city: City,
    onClick: (City) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(city) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = city.name)
            Text(text = city.state)
            Text(text = "Population: ${city.population}")
            Text(text = if (city.visited) "Visited" else "Not visited")
        }
    }
}
