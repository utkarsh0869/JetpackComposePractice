package com.example.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposepractice.ui.theme.JetpackComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposePracticeTheme {
                Scaffold { innerPadding ->
                    FirstApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FirstApp(modifier: Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Color.Blue,
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Text(
            text = "My First App Practice",
            fontSize = 32.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FirstAppPreview(modifier: Modifier = Modifier) {
    JetpackComposePracticeTheme {
        FirstApp(modifier)
    }
}