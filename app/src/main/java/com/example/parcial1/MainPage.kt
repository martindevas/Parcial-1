package com.example.parcial1
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial1.ui.theme.Parcial1Theme

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    Column(modifier.padding(horizontal = 30.dp)) {
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
        TextField(
            value = "Email", onValueChange = {}, modifier = modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
        )
        TextField(
            value = "Clave", onValueChange = {}, modifier = modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
        )
        Button(
            onClick = { }, modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp)
        ) {
            Text(
                text = "Ingresar ",
                modifier = modifier.padding(horizontal = 20.dp)
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