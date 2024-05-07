package com.example.parcial1

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcial1.ui.theme.Parcial1Theme

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    Text(
        text = "Hola",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    Parcial1Theme {
        MainPage()
    }
}