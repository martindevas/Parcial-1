package com.example.parcial1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.parcial1.ui.theme.Parcial1Theme


@Composable
fun ContraseñaCorrecta(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¡Bienvenido usuario: Pedro Pe!")
    },
}
@Preview(showBackground = true)
@Composable
fun ContraseñaCorrectaPreview() {
    Parcial1Theme {
        val navController = rememberNavController()
        ContraseñaCorrecta(navController = navController)
    }
}