package com.example.practica4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica4.ui.theme.Practica4Theme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaSaludo(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
class SaludoViewModel : ViewModel() {
    private val _nombre = MutableStateFlow("")
    val nombre: StateFlow<String> = _nombre
    private val _saludo = MutableStateFlow("")
    val saludo: StateFlow<String> = _saludo
    fun onNombreChange(nuevoNombre: String) {
        _nombre.value = nuevoNombre
    }
    fun saludar() {
        _saludo.value = "Hola ${_nombre.value}"
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practica4Theme {
        Greeting("Android")
    }
}

@Composable
fun PantallaSaludo(viewModel: SaludoViewModel = viewModel(), name: String, modifier: Modifier) {
    val nombre by viewModel.nombre.collectAsState()
    val saludo by viewModel.saludo.collectAsState()
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { viewModel.onNombreChange(it) },
            label = { Text("Nombre") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.saludar() }) {
            Text("Saludar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = saludo)
    }
}