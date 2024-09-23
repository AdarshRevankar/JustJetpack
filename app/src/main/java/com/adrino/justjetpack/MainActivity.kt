package com.adrino.justjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrino.justjetpack.model.MusicInfo

class MainActivity : ComponentActivity() {

    private val messages = arrayOf(
        MusicInfo("Akon ! Smack That", R.drawable.icon_music),
        MusicInfo("Butterflies and hurricanes", R.drawable.icon_music),
        MusicInfo("Salam Rocky Bhai", R.drawable.icon_music)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageDashboard(messages)
        }
    }
}

@Preview
@Composable
fun PreviewMessageView() {
    MessageView(musicInfo = MusicInfo("Hello World", R.drawable.icon_music))
}

@Composable
fun MessageDashboard(messages: Array<MusicInfo>) {
    Column(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        messages.forEach { message ->
            MessageView(musicInfo = message)
        }
    }
}

@Composable
fun MessageView(musicInfo: MusicInfo) {
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(painterResource(id = musicInfo.albumArt), contentDescription = null)
        Text(text = musicInfo.musicTitle)
        var isRadioButtonSelected = false
        Spacer(modifier = Modifier.fillMaxWidth())
        RadioButton(selected = isRadioButtonSelected, onClick = {
            isRadioButtonSelected = !isRadioButtonSelected
        })
    }
}