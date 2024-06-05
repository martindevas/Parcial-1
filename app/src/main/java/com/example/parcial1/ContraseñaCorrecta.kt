package com.example.parcial1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0F7FA)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_image), // Asegúrate de tener una imagen en el directorio drawable
            contentDescription = "Welcome Image",
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Accediste con éxito",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
            color = Color(0xFF00796B)
        )
        Text(
            text = "¡Bienvenido!",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
            color = Color(0xFF004D40)
        )
        Text(
            text = usuario,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
            color = Color(0xFF004D40)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContraseñaCorrectaPreview() {
    Parcial1Theme {
        ContraseñaCorrecta("Pedro Pe")
    }
}