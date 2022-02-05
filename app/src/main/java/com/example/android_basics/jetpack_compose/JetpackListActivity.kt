package com.example.android_basics.jetpack_compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_basics.R
import com.example.android_basics.jetpack_compose.dataset.SampleData
import java.util.*

class JetpackListActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            MessageCard(Message("Android", "Jetpack Compose"))
//        }
        setContent {
            conversation(messages = SampleData.conversationSample)
        }
    }
}

data class Message(val name: String, val desc: String)

@Composable
fun conversation(messages: List<Message>){
    LazyColumn{

        items(
            items = messages,
            itemContent = {
//                val random = Random()
//                val color = Color(random.nextInt(256), random.nextInt(256), random.nextInt(256))
                MessageCard(it, Color(0, 0, 0))
            })

//        items(messages){ message ->
//            val random = Random()
//            val color = Color(random.nextInt(256), random.nextInt(256), random.nextInt(256))
//            MessageCard(message = message, color = color)
//
//        }
    }
}

@Composable
fun MessageCard(message: Message, color: Color) {

    val current = System.currentTimeMillis()
    Row(Modifier.padding(2.dp)) {
        //horizontal space
        Spacer(modifier = Modifier.width(8.dp))

        Text(text = "${message.name}", color = color)
        Text(text = "${message.desc}", color = color)
        Text(text = "${message.name}", color = color)
        Text(text = "${message.desc}", color = color)
    }
    Row(Modifier.padding(2.dp)) {
        //horizontal space
        Spacer(modifier = Modifier.width(8.dp))

        Text(text = "${message.name}", color = color)
        Text(text = "${message.desc}", color = color)
        Text(text = "${message.name}", color = color)
        Text(text = "${message.desc}", color = color)
    }
    Row(Modifier.padding(2.dp)) {
        //horizontal space
        Spacer(modifier = Modifier.width(8.dp))

        Text(text = "${message.name}", color = color)
        Text(text = "${message.desc}", color = color)
        Text(text = "${message.name}", color = color)
        Text(text = "${message.desc}", color = color)
    }

    Row(Modifier.padding(2.dp)) {
        //horizontal space
        Spacer(modifier = Modifier.width(8.dp))

        Text(text = "${message.name}", color = color)
        Text(text = "${message.desc}", color = color)
        Text(text = "${message.name}", color = color)
        Text(text = "${message.desc}", color = color)
    }

    Row(Modifier.padding(2.dp)) {
        //horizontal space
        Spacer(modifier = Modifier.width(8.dp))

        Text(text = "${message.name}", color = color)
        Text(text = "${message.desc}", color = color)
        Text(text = "${message.name}", color = color)
        Text(text = "${message.desc}", color = color)
    }
    Log.d("TAG", "Time taken by jetpack compose: ${System.currentTimeMillis() - current}")
}

@Preview
@Composable
fun previewMessageCard() {
    conversation(messages = SampleData.conversationSample)
}