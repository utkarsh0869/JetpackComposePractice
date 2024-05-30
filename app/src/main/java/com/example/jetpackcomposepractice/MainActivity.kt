package com.example.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
//    SurfaceComposableWithColumnsAndRows(modifier)
//    NestedBoxComposable(modifier)
//    ModifierPractice()
//    ButtonComposableTypes()
    StylingButtonComposable()


}

@Composable
fun StylingButtonComposable(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 20.dp)
        ) {
            Text(text = "Rounded corner button")
        }
        Button(
            onClick = { /*TODO*/ },
            shape = CutCornerShape(10.dp)
        ) {
            Text(text = "Cut corner button")
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .size(100.dp),
            shape = androidx.compose.foundation.shape.CircleShape
        ) {
//            Text(text = "Circe button")
            Icon(imageVector = Icons.Filled.Add, contentDescription = "")
        }
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(10.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 5.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xfffedbd0),
                contentColor = Color.Red
            ),
            border = BorderStroke(1.dp, Color.Magenta)
        ) {
            Text(text = "Rounded corner button")
            Icon(imageVector = Icons.Filled.Face, contentDescription = "")
        }

    }
}
@Composable
fun ButtonComposableTypes() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { /*TODO*/ }) {
            Text(
                text = "DEFAULT BUTTON"
            )
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(
                text = "OUTLINED BUTTON"
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Done,
                contentDescription = "",
                tint = Color.Red,
                modifier = Modifier
                    .size(ButtonDefaults.IconSize)
            )
        }
        TextButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = "",
                tint = Color.Red,
                modifier = Modifier
                    .size(ButtonDefaults.IconSize)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Above is the Icon Button")
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = "",
                tint = Color.Red,
                modifier = Modifier
                    .size(ButtonDefaults.IconSize)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Icon(
                imageVector = Icons.Filled.Face,
                contentDescription = "",
                tint = Color.Red,
                modifier = Modifier
                    .size(ButtonDefaults.IconSize)
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Icon(imageVector = Icons.Filled.Build, contentDescription = "")
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
            Text(text = "BUILD")
        }
    }
}

@Composable
fun ModifierPractice() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Just Compose Practice",
            modifier = Modifier
                .padding(10.dp) // Acts as a margin
                .background(Color.Green)
                .padding(10.dp)
//                .fillMaxSize()
//                .size(150.dp) // Use size for equal height and width
        )
        Box(
            modifier = Modifier
                .padding(60.dp)
                .size(250.dp)
                .rotate(45f)
//                .alpha(0.3f) // transparency
                .clip(CutCornerShape(20.dp))
                .border(5.dp, Color.Black, CutCornerShape(20.dp))
                .background(Color.Cyan)
                .align(alignment = Alignment.CenterHorizontally)
                .clickable {

                }

        ) {

        }
    }
}

@Composable
fun NestedBoxComposable(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color.Yellow)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .width(250.dp)
                .height(250.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Green)
                // Not specifying the width and height wraps the content according to the size
                // of the text below.
//                    .width(150.dp)
//                    .height(150.dp)
            ) {
                Text(
                    text = "Just Practicing",
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun SurfaceComposableWithColumnsAndRows(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        color = Color.Green,
        shape = CutCornerShape(20.dp),
        border = BorderStroke(2.dp, color = Color.Red),
        shadowElevation = 16.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            MyText(
                text = "My First App Practice",
                fontSize = 32.sp,
                modifier = Modifier.padding(start = 15.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                MyText(
                    text = "Hello World",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp)
                )
                MyText(
                    text = "Utkarsh Karki",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 15.dp, top = 10.dp)
                )
            }
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