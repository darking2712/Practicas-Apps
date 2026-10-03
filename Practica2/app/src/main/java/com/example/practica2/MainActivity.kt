package com.example.practica2

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica2.ui.theme.Practica2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaContador1(
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
    Practica2Theme {
        Greeting("Android")
    }
}

@Composable
fun Pantalla(modifier: Modifier = Modifier) {
    var contador=0
    Button(onClick= {contador++ }) {
        Text("Contador: $contador")
    }
}

@Composable
fun PantallaContador1(modifier: Modifier = Modifier) {
    val contador=remember { mutableIntStateOf(0) }
    Column {
        Text("Contador: ${contador.intValue}")
        Button(onClick= {
            contador.intValue++
        }) {
            Text("Sumar")
        }
    }
}
@Composable
fun PantallaContador2(modifier: Modifier = Modifier) {
    var contador by remember { mutableIntStateOf(0) }
    Column {
        Text("Contador: $contador")
        Button(onClick= {
            contador++
        }) {
            Text("Sumar")
        }
    }
}
@Composable
fun PantallaEjemplo(modifier: Modifier = Modifier) {
    var nombre by remember {mutableStateOf("") }
    Column(
        modifier=Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value=nombre,
            onValueChange= {nombre=it },
            label= {Text("Nombre") }
        )
        Spacer(modifier=Modifier.height(16.dp))
        Text("Hola $nombre")
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaEjemploPreview(){
    Practica2Theme{
        PantallaEjemplo()
    }
}


@Preview(showBackground = true)
@Composable
fun PantallaContadorPreview(){
    Practica2Theme{
        PantallaContador2()
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPreview(){
    Practica2Theme{
        Pantalla()
    }
}
