package com.example.l08_lists_states

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CityViewModel : ViewModel() {
    private val _cities = MutableStateFlow(initialCities)
    val cities = _cities.asStateFlow()

    fun delete(id: Int) {
        _cities.update { list ->
            list.filterNot { it.id == id }
        }
    }

    fun toggleVisited(id: Int) {
        _cities.update { list ->
            list.map { city ->
                if (city.id == id) city.copy(visited = !city.visited)
                else city
            }
        }
    }
}
