package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SignInScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo de pantalla
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Contenedor blanco
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = LocalConfiguration.current.screenHeightDp.dp * 0.2536f)
                .background(Color.White, shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Bienvenido",
                    fontSize = 32.sp, // 🔹 Más grande
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3574F2),
                    modifier = Modifier.padding(vertical = 24.dp) // 🔹 Más espacio arriba y abajo
                )

                var cedula by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var passwordVisible by remember { mutableStateOf(false) }

                CustomTextField(label = "Cédula", value = cedula, onValueChange = { cedula = it })
                Spacer(modifier = Modifier.height(16.dp))
                CustomTextField(
                    label = "Contraseña",
                    value = password,
                    onValueChange = { password = it },
                    isPassword = true,
                    passwordVisible = passwordVisible,
                    onPasswordToggle = { passwordVisible = !passwordVisible }
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "¿Olvidaste tu contraseña?",
                    fontSize = 14.sp,
                    color = Color(0xFF3574F2),
                    modifier = Modifier.align(Alignment.End)
                )
                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { /* Acción de iniciar sesión */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3574F2)),
                    shape = RoundedCornerShape(15.dp), // 🔹 Radio en todos los bordes
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp) // 🔹 Más alto
                ) {
                    Text(text = "Iniciar sesión", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }


                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "¿No tienes una cuenta? Regístrate",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
    passwordVisible: Boolean = false,
    onPasswordToggle: (() -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        shape = RoundedCornerShape(16.dp), // 🔹 Ahora tiene 16.dp en todas las esquinas
        singleLine = true,
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFFD9D9D9),
            unfocusedBorderColor = Color(0xFFD9D9D9)
        )
    )
}
