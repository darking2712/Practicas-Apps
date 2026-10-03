package com.example.practica3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica3.ui.theme.Practica3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaRegistro(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
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
    Practica3Theme {
        Greeting("Android")
    }
}

@Composable
fun CampoNombre(
    nombre: String,
    onNombreChange: (String) -> Unit
) {
    OutlinedTextField(
        value = nombre,
        onValueChange = onNombreChange,
        label = { Text("Nombre") },
        modifier = Modifier.fillMaxWidth()
    )
}
/*
@Composable
fun CampoEmail(
    email: String,
    onEmailChange: (String) -> Unit
) {
    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        label = { Text("Email") }
    )
}
*/
/*
@Composable
fun PantallaRegistro1() {
    Column {
        CampoNombre()
        Button(onClick = { }) {
            Text("Guardar")
        }
    }
}
*/

@Composable
fun PantallaRegistro(modifier: Modifier) {
    var nombre by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        CampoNombre(
            nombre = nombre,
            onNombreChange = { nombre = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Hola $nombre")
    }
}
/*
@Composable
fun PantallaSaludo(viewModel: SaludoViewModel = viewModel()) {
    val nombre by viewModel.nombre
    Column {
        CampoNombre(
            nombre = nombre,
            onNombreChange = { viewModel.onNombreChange(it) }
        )
        Button(onClick = { viewModel.saludar() }) {
            Text("Saludar")
        }
    }
}
*/
