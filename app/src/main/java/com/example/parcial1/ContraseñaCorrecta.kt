package com.example.parcial1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial1.ui.theme.Parcial1Theme


@Composable
fun ContraseñaCorrecta(
    usuario: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Accediste con exito",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "¡Bienvenido!",
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = "Pedro Pe",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )
        }

    }
}
@Preview(showBackground = true)
@Composable
fun ContraseñaCorrectaPreview() {
    Parcial1Theme {
        ContraseñaCorrecta("")
    }
}