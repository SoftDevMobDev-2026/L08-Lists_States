package com.example.l08_lists_states

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                Surface {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
//    Based on the Seminar Slides, go through them one y one by uncommemnting/commenting them
//    1.
    //BasicListDemo()
//    2.
//    CounterDemo()
//    3.
//    StateHoistingDemo()
//    4.
//    CityScreen()
//    5.
//    CityListDemo()
//    6.
//    LazyRowDemo()
//    7.
//    LazyVerticalGridDemo()
//    8.
//      CityUiStateDemo()
//    9.
    val cityViewModel: CityViewModel = viewModel()
    ViewModelListDemo(cityViewModel)
}
