package com.example.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
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
            .height(150.dp).width(400.dp)
            .padding(16.dp),
        color = Color.Green,
        shape = CutCornerShape(20.dp),
        border = BorderStroke(2.dp, color = Color.Red),
        shadowElevation = 16.dp
    ) {
        Column {
            MyText(text = "My First App Practice", fontSize = 32.sp, modifier = Modifier.padding(start = 15.dp))
            MyText(text = "Hello World", fontSize = 16.sp, modifier = Modifier.padding(start = 15.dp, top = 10.dp))
            MyText(text = "Utkarsh Karki", fontSize = 12.sp, modifier = Modifier.padding(start = 15.dp, top = 10.dp))
        }
    }
}

@Composable
fun MyText(
    text: String,
    fontSize: TextUnit,
    modifier: Modifier
) {
    Text(
        text = text,
        fontSize = fontSize,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun FirstAppPreview(modifier: Modifier = Modifier) {
    JetpackComposePracticeTheme {
        FirstApp(modifier)
    }
}