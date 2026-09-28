package com.example.l08_lists_states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CityUiStateDemo() {

    var uiState by remember {
        mutableStateOf<CityUiState>(
            CityUiState.Loading
        )
    }

    val cities = listOf(
        City(1, "Melbourne", "VIC", 5_300_000),
        City(2, "Sydney", "NSW", 5_500_000),
        City(3, "Brisbane", "QLD", 2_700_000)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // These buttons are for demonstrating
        // the different UI states.
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Button(
                onClick = {
                    uiState = CityUiState.Loading
                }
            ) {
                Text("Loading")
            }

            Button(
                onClick = {
                    uiState = CityUiState.Success(cities)
                }
            ) {
                Text("Success")
            }

            Button(
                onClick = {
                    uiState = CityUiState.Error(
                        "Unable to load cities"
                    )
                }
            ) {
                Text("Error")
            }
        }

        // Display UI based on the current state
        when (val state = uiState) {

            CityUiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.padding(16.dp)
                )
            }

            is CityUiState.Success -> {
                LazyColumn(
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    items(
                        items = state.cities,
                        key = { it.id }
                    ) { city ->
                        CityRow(city)
                    }
                }
            }

            is CityUiState.Error -> {
                Text(
                    text = state.message,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}