package com.example.jetcomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetcomposebasics.ui.theme.JetComposeBasicsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent(List(100) {"Android $it"})
            }
        }
    }
}

@Composable
fun MyApp(functionContent : @Composable () -> Unit){
    JetComposeBasicsTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = Color.Yellow) {
            functionContent()
        }
    }

}


@Composable
fun MyScreenContent(names: List<String> = List(100) {"Android $it"}) {
    val counterState = remember { mutableStateOf(0) }
    
    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(names = names, modifier = Modifier.weight(1f))

        Counter(count = counterState.value ,
            updateCounter = { newCount ->
                counterState.value = newCount} )

    }


}

@Composable
fun NameList(names : List <String>, modifier: Modifier = Modifier){

    LazyColumn(modifier = modifier) {
        items(items = names) { name ->
            Greeting(name, Color.Blue)
            Divider(color = Color.Black)
        }
    }


}


@Composable
fun Greeting(name: String, color: Color) {

    var isSelected by remember { mutableStateOf(false)}
    val backgroundColor by animateColorAsState(if(isSelected) Color.Green else Color.Transparent)


    Text(text = "Hello $name!",
        color = color,
        modifier = Modifier.padding(24.dp)
            .background(color = backgroundColor)
            .clickable (onClick = { isSelected = !isSelected}))
}

@Composable
fun Counter(count : Int, updateCounter: (Int)-> Unit){

    Button(onClick = { updateCounter(count + 1) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if(count>3) Color.Magenta else Color.Gray
        )
    ) {
        Text("Clicked $count times")
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp{
        MyScreenContent()
    }

}