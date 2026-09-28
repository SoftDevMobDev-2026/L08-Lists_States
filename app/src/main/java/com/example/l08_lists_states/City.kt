package com.example.l08_lists_states

data class City(
    val id: Int,
    val name: String,
    val state: String,
    val population: Int,
    val visited: Boolean = false
)

val initialCities = listOf(
    City(1, "Melbourne", "VIC", 5_300_000),
    City(2, "Sydney", "NSW", 5_500_000),
    City(3, "Brisbane", "QLD", 2_700_000),
    City(4, "Perth", "WA", 2_300_000),
    City(5, "Adelaide", "SA", 1_400_000)
)
