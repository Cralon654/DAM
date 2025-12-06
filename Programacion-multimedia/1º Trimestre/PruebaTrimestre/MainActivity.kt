package com.example.apploggin

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.apploggin.ui.theme.AppLogginTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import kotlin.math.log

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppLogginTheme {
                NavegacionApp()
            }
        }
    }

    @Composable
    fun NavegacionApp() {
        // Controlador de navegación
        val navegar = rememberNavController()


        // Contenedor principal donde definimos las pantallas
        NavHost(
            navController = navegar,
            startDestination = "inicio"   // ruta inicial
        ) {
            // Rutas disponibles
            composable("inicio") { PantallaLoggin(navegar) } // Compartimos la navegación
            composable("detalle") { PantallaBienvenida(navegar) } // Ejemplo sijmple, puebas
        }
    }

    @Composable
    fun PantallaLoggin(navegar: NavController) {
        var loggin by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var errorMessage by remember { mutableStateOf<String?>(null) }
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = loggin,
                onValueChange = { loggin = it },
                placeholder = { Text("User") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFFEBEE),   // fondo rosado claro
                    unfocusedContainerColor = Color(0xFFFFEBEE),
                    focusedIndicatorColor = Color(0xFFC8102E),   // rojo bermellón
                    unfocusedIndicatorColor = Color.DarkGray,
                    focusedLabelColor = Color(0xFFC8102E),
                    cursorColor = Color(0xFFC8102E),
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(), //contraseña
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFFEBEE),   // fondo rosado claro
                    unfocusedContainerColor = Color(0xFFFFEBEE),
                    focusedIndicatorColor = Color(0xFFC8102E),   // rojo bermellón
                    unfocusedIndicatorColor = Color.DarkGray,
                    focusedLabelColor = Color(0xFFC8102E),
                    cursorColor = Color(0xFFC8102E),
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )

            errorMessage?.let {
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error, // Color rojo para el error
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Button(
                onClick = {
                    errorMessage = null

                    if (loggin.isEmpty() || password.isEmpty()) {

                        errorMessage = "Por favor, completa ambos campos."
                    } else {
                        loggin = ""    // Vacia el campo de usuario
                        password = ""  // Vacia el campo de contraseña
                        navegar.navigate("detalle")
                    }
                }
            ) {
                Text("Loggin")
            }


        }
    }
    @Composable
    fun PantallaBienvenida(navegar: NavHostController) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Bienvenido/a")

            Button(onClick = { navegar.popBackStack() }) {
                Text("Volver")
            }
        }

    }


}
