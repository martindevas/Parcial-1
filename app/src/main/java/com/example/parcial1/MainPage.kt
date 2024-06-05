package com.example.parcial1
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial1.ui.theme.Parcial1Theme

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    val navHostController = rememberNavController()
    Scaffold(
        modifier = Modifier
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
        startDestination = "login"
    ) {
        composable("login") {
            Ingreso(navHostController, modifier = modifier)
        }
        composable("home") {
            ContraseñaCorrecta(
                usuario = "Pedro Pe"
            )
        }
    }
}
fun VerificacionUsuario(usuario: String, contraseña: String): Boolean {
    val usuarioAValidar = "pedro@pe.com.ar"
    val contraseñaAValidar = "abc123"
    return usuario == usuarioAValidar && contraseña == contraseñaAValidar
}

@Composable
fun Ingreso(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
){
    val usuarioIngresado = remember { mutableStateOf("") }
    val contraseñaIngresada = remember { mutableStateOf("") }
    val error = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Hola!",
            modifier = modifier.padding(vertical = 10.dp)
        )
        Row(modifier.padding()) {
            Text(
                text = "Ingresa a tu cuenta",
                modifier = modifier
            )
        }
        OutlinedTextField(
            value = usuarioIngresado.value,
            onValueChange = { usuarioIngresado.value = it },
            label = { Text("Email") },
            modifier = Modifier.padding(bottom = 10.dp)
        )
        OutlinedTextField(
            value = contraseñaIngresada.value,
            onValueChange = { contraseñaIngresada.value = it },
            label = { Text("Clave") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Button(
            onClick = {
                val usuario = usuarioIngresado.value
                val contraseña = contraseñaIngresada.value
                if (VerificacionUsuario(usuario, contraseña)) {
                    error.value = false
                    navHostController.navigate("home")
                } else {
                    error.value = true
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Ingresar")
        }
        if (error.value) {
            Text(
                text = "Usuario o contraseña incorrectos!",
                modifier = Modifier.padding(top = 8.dp)
            )
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