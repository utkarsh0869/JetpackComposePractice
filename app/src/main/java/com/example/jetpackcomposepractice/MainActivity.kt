package com.example.jetpackcomposepractice

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposepractice.ui.theme.JetpackComposePracticeTheme
import kotlin.random.Random

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
//    StylingButtonComposable()
//    ButtonOnClickPractice()
//    StylingTextComposable()
//    TextFieldWithToastMessage()
//    StylingTextField()
//    ImageComposablePractice()
//    CardComposable()
//    LazyRowAndColumnComposable()
//    LazyColumnWithImagePractice(modifier)
    LazyGridComposable()
}

@Composable
fun LazyGridComposable(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp), // .Fixed(2) -- needs a count i.e. column count
        contentPadding = PaddingValues(16.dp),
    ) {
        items(200) {
            MyCard(
                it,
                modifier
            )
        }
    }
}

@Composable
fun MyCard(
    it: Int,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .size(100.dp)
            .padding(6.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f
            )
        )
    ) {
        Box(
            modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = it.toString(), fontSize = 22.sp)
        }
    }
}

@Composable
fun LazyColumnWithImagePractice(modifier: Modifier) {
    val imageId = arrayOf(
        R.drawable.utkarsh,
        R.drawable.utkarsh,
        R.drawable.utkarsh,
        R.drawable.utkarsh,
        R.drawable.utkarsh,
        R.drawable.utkarsh,
    )
    val names = arrayOf(
        "This",
        "is",
        "me",
        "Utkarsh",
        "Karki",
        "Haha"
    )
    val ingredients = arrayOf(
        "Tomato sauce, cheese",
        "Tomato sauce, cheese, spinach",
        "Tomato sauce, cheese, spinach, goda",
        "Tomato sauce, cheese, spinach, goda, pineapple",
        "Tomato sauce, cheese, spinach, goda, pineapple, jalapeno",
        "Tomato sauce, cheese, spinach, goda, pineapple, jalapeno, chicken",
    )
    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        val itemCount = imageId.size
        items(itemCount) { item ->
            ColumnItem(
                itemIndex = item,
                painter = imageId,
                title = names,
                ingredients = ingredients,
                modifier = modifier
            )
        }
    }
}

@Composable
fun ColumnItem(
    itemIndex: Int,
    painter: Array<Int>,
    title: Array<String>,
    ingredients: Array<String>,
    modifier: Modifier
) {
    Card(
        modifier
            .padding(10.dp)
            .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                Modifier.size(140.dp)
            )
            Column {
                Text(
                    text = title[itemIndex],
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Text(
                    text = ingredients[itemIndex],
                    fontSize = 18.sp
                )
            }

        }
    }
}

@Composable
fun LazyRowAndColumnComposable() {
    val languages = listOf(
        "C++",
        "Kotlin",
        "Java",
        "C#",
        "Go",
        "JavaScript",
        "PHP",
        "HTML",
        "CSS",
        "Python",
        "Swift"
    )
    Column(
        Modifier
            .fillMaxSize()
    ) {
        LazyRow(
//            contentPadding = PaddingValues(10.dp)
        ) {
            items(items = languages) { item ->
                RowItem(name = item)
            }
        }
        LazyColumn(
            contentPadding = PaddingValues(10.dp)
        ) {
            items(items = languages) { item ->
                ColumnItems(name = item)
            }
        }
    }
}

@Composable
fun ColumnItems(name: String) {
    Card(
        Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .aspectRatio(3f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            Modifier
                .padding(10.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Composable
fun RowItem(name: String) {
    Card(
        Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp)
            .aspectRatio(1.5f),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            Modifier
                .padding(10.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Composable
fun CardComposable() {
    Box(
        Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            Modifier
                .width(250.dp)
                .height(400.dp),
//            shape = CutCornerShape(20.dp) // optional for cut cornered cards
            elevation = CardDefaults.elevatedCardElevation(10.dp),
            border = BorderStroke(3.dp, Color.Gray),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(
                    painter = painterResource(id = R.drawable.utkarsh),
                    contentDescription = "me",
                    Modifier
                        .aspectRatio(1f)
                )
                Text(
                    text = "Utkarsh Karki",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Text(
                    text = "This is me Utkarsh Karki practing Jetpack Compose, right now I am " +
                            "styling the Text Composable with max lines as 3 and overflow",
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(6.dp),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray

                )
            }
        }
    }
}

@Composable
fun ImageComposablePractice() {
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.utkarsh),
            contentDescription = "me",
            Modifier
                .padding(10.dp)
                .size(175.dp)
                .clip(RoundedCornerShape(16.dp))
                .border(width = 4.dp, color = Color.Red, shape = RoundedCornerShape(16.dp))
//            contentScale = ContentScale.FillBounds,
//            alpha = .2f
        )
        Image(
            painter = painterResource(id = R.drawable.utkarsh),
            contentDescription = "me",
            Modifier
                .padding(10.dp)
                .size(175.dp)
                .clip(CutCornerShape(16.dp))
                .border(width = 4.dp, color = Color.Red, shape = CutCornerShape(16.dp))
        )
        Image(
            painter = painterResource(id = R.drawable.utkarsh),
            contentDescription = "me",
            Modifier
                .padding(10.dp)
                .size(175.dp)
                .clip(CircleShape)
                .border(width = 4.dp, color = Color.Red, shape = CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StylingTextField() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 40.dp),
        contentAlignment = Alignment.Center
    ) {
        var textState by remember {
            mutableStateOf("")
        }
        val myColor = Color(0xFFD50000)
        TextField(
            value = textState,
            onValueChange = {
                textState = it
            },
            label = {
                Text(text = "Your Name")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = ""
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Send,
                    contentDescription = ""
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedLabelColor = myColor,
                focusedLabelColor = myColor,
                cursorColor = myColor,
                focusedLeadingIconColor = myColor,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTrailingIconColor = myColor,
                unfocusedTrailingIconColor = myColor,
                unfocusedLeadingIconColor = myColor,
                focusedIndicatorColor = Color.Transparent,
                containerColor = myColor.copy(.2f)
//                containerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(topStart = 25.dp, bottomEnd = 25.dp) // CutCornerShape
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TextFieldWithToastMessage() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var newTextValue by remember {
            mutableStateOf("")
        }
        val context = LocalContext.current
        val keyboardController = LocalSoftwareKeyboardController.current
        Column(
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            TextField(
                value = newTextValue,
                onValueChange = {
                    newTextValue = it
                },
                label = {
                    Text(
                        text = "Enter your email"
                    )
                },
                maxLines = 1,
                singleLine = true,
                modifier = Modifier
                    .width(300.dp),
                placeholder = {
                    Text(
                        text = "test@xyz.com"
                    )
                },
                // visualTransformation = PasswordVisualTransformation() // for passwords - black dots
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Email, contentDescription = "")
                },
                trailingIcon = {
                    IconButton(onClick = { // used if onClick is needed
                        Toast.makeText(context, newTextValue, Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Outlined.Send, contentDescription = "")
                    }
                }
            )
            OutlinedTextField(
                value = newTextValue,
                onValueChange = {
                    newTextValue = it
                },
                label = {
                    Text(
                        text = "Enter your email"
                    )
                },
                maxLines = 1,
                singleLine = true,
                modifier = Modifier
                    .width(300.dp),
                placeholder = {
                    Text(
                        text = "test@xyz.com"
                    )
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Email, contentDescription = "")
                },
                trailingIcon = {
                    IconButton(onClick = {
//                        Toast.makeText(context, newTextValue, Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Outlined.Send, contentDescription = "")
                    }
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters,
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Send
                ),
                keyboardActions = KeyboardActions(
                    onSend = {
                        keyboardController?.hide()
                        Toast.makeText(context, "Send Button Pressed", Toast.LENGTH_SHORT).show()
                    }
                )
            )
            BasicTextField(value = "Basic Text Field", onValueChange = {})
        }
    }
}

@Composable
fun StylingTextComposable() {
    val myFont = FontFamily(Font(R.font.architects_daughter))
    Column {
        Text(
            text = stringResource(R.string.practice).repeat(10),
            color = Color.Blue,
            fontSize = 15.sp,
            //        fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            fontFamily = myFont,
            //        textDecoration = TextDecoration.LineThrough,
            //        textAlign = TextAlign.Center,
            lineHeight = 40.sp,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .background(Color.Gray)
                .width(400.dp)
        )
        Text(text = buildAnnotatedString {
            withStyle(style = ParagraphStyle(textIndent = TextIndent(firstLine = 20.sp))) {
                withStyle(style = SpanStyle(color = Color.Blue, fontSize = 30.sp)) {
                    append("J")
                }
                append("etpack")
                withStyle(style = SpanStyle(color = Color.Blue, fontSize = 30.sp)) {
                    append("C")
                }
                append("ompose")
            }
            append("ompose")
        })
    }

}

@Composable
fun ButtonOnClickPractice() {
    var count by rememberSaveable {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            count++
            Log.d("Count", "$count")
        }) {
            Text(text = "Count $count")
        }
    }
}

@Composable
fun StylingButtonComposable() {
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