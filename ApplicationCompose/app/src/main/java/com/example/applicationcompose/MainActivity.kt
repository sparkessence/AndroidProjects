package com.example.applicationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MessageCard(Message("Android", "Jetpack Compose")) }
    }

}

data class Message(val author:String , val body : String)

@Composable
fun MessageCard(msg : Message) {

Row(modifier = Modifier.padding(all =16.dp)) {

    Image(painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription ="Profile Image",
        modifier = Modifier.size(40.dp).clip(CircleShape))
    Spacer(modifier = Modifier.width(8.dp))
    Column() {

        Text(msg.author)
        Spacer(modifier = Modifier.height(4.dp))
        Text(msg.body)
    }


}



}

@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(Message("Android", "Jetpack Compose"))
}
