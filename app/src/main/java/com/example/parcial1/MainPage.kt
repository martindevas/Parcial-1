@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.parcial1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial1.ui.theme.Parcial1Theme

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    val navHostController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        MainNavHost(
            modifier = Modifier.padding(it),
            navHostController = navHostController,
        )
    }
}

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = "ingreso"
    ) {
        composable("ingreso") {
            Ingreso(navHostController, modifier = modifier)
        }
        composable("home") {
            ContraseñaCorrecta(
                usuario = "Pedro Pe"
            )
        }
    }
}

fun VerificacionUsuario(usuario: String, contraseña: String): Pair<Boolean, Boolean> {
    val usuarioAValidar = "pedro@pe.com.ar"
    val contraseñaAValidar = "abc123"
    val usuarioValido = usuario == usuarioAValidar
    val contraseñaValida = contraseña == contraseñaAValidar
    return Pair(usuarioValido, contraseñaValida)
}

@Composable
fun Ingreso(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
){
    val emailIngresado = remember { mutableStateOf("") }
    val contraseñaIngresada = remember { mutableStateOf("") }
    val errorUsuario = remember { mutableStateOf(false) }
    val errorContraseña = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0F7FA))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Hola!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF004D40),
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Text(
                text = "Ingresa a tu cuenta",
                fontSize = 18.sp,
                color = Color(0xFF00796B),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 10.dp)
            )
            OutlinedTextField(
                value = emailIngresado.value,
                onValueChange = {
                    emailIngresado.value = it
                    errorUsuario.value = false // Reset error when user starts typing
                },
                label = { Text("Email") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFE0F7FA),
                    focusedBorderColor = Color(0xFF004D40),
                    unfocusedBorderColor = Color(0xFF00796B)
                ),
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            OutlinedTextField(
                value = contraseñaIngresada.value,
                onValueChange = {
                    contraseñaIngresada.value = it
                    errorContraseña.value = false // Reset error when user starts typing
                },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFE0F7FA),
                    focusedBorderColor = Color(0xFF004D40),
                    unfocusedBorderColor = Color(0xFF00796B)
                ),
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Button(
                onClick = {
                    val usuario = emailIngresado.value
                    val contraseña = contraseñaIngresada.value
                    val (usuarioValido, contraseñaValida) = VerificacionUsuario(usuario, contraseña)
                    if (usuarioValido && contraseñaValida) {
                        errorUsuario.value = false
                        errorContraseña.value = false
                        navHostController.navigate("home")
                    } else {
                        errorUsuario.value = !usuarioValido
                        errorContraseña.value = !contraseñaValida
                    }
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .clip(RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF004D40),
                    contentColor = Color.White
                )
            ) {
                Text("Ingresar")
            }
            if (errorUsuario.value && errorContraseña.value) {
                Text(
                    text = "Usuario y contraseña incorrectos!",
                    modifier = Modifier.padding(top = 8.dp)
                )
            } else if (errorUsuario.value) {
                Text(
                    text = "Email incorrecto!",
                    modifier = Modifier.padding(top = 8.dp)
                )
            } else if (errorContraseña.value) {
                Text(
                    text = "Contraseña incorrecta!",
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    Parcial1Theme {
        MainPage()
    }
}