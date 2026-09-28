package com.example.l08_lists_states

sealed class CityUiState {

    data object Loading : CityUiState()

    data class Success(
        val cities: List<City>
    ) : CityUiState()

    data class Error(
        val message: String
    ) : CityUiState()
}
