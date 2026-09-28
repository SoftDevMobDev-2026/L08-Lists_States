package com.example.l08_lists_states

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun CityScreen() {
    var cities by remember {
        mutableStateOf(initialCities)
    }

    LazyColumn {
        items(
            items = cities,
            key = { it.id }
        ) { city ->
            CityRow(city)
        }
    }
}
