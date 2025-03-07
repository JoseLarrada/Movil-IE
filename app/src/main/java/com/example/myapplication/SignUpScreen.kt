package com.example.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SignUpScreen(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var cedula by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Empieza ahora", fontSize = 28.sp)
            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(label = "Nombre", value = nombre, onValueChange = { nombre = it })
            Spacer(modifier = Modifier.height(12.dp))
            CustomTextField(label = "Apellido", value = apellido, onValueChange = { apellido = it })
            Spacer(modifier = Modifier.height(12.dp))
            CustomTextField(label = "Cédula", value = cedula, onValueChange = { cedula = it })
            Spacer(modifier = Modifier.height(12.dp))
            CustomTextField(label = "Teléfono", value = telefono, onValueChange = { telefono = it })
            Spacer(modifier = Modifier.height(12.dp))
            CustomTextField(label = "Correo electrónico", value = email, onValueChange = { email = it })
            Spacer(modifier = Modifier.height(12.dp))
            CustomTextField(
                label = "Contraseña",
                value = password,
                onValueChange = { password = it },
                isPassword = true,
                passwordVisible = passwordVisible,
                onPasswordToggle = { passwordVisible = !passwordVisible }
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { /* Acción de registro */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrarse")
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = { navController.popBackStack() }) {
                Text("¿Ya tienes una cuenta? Inicia sesión")
            }
        }
    }
}
