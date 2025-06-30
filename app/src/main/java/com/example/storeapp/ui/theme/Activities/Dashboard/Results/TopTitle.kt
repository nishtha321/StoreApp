package com.example.storeapp.ui.theme.Activities.Dashboard.Results

import android.icu.text.CaseMap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.storeapp.R
import java.nio.file.WatchEvent


@Composable
@Preview
fun TopTitle(

    title: String = "title",
    onBackClick:()-> Unit = {}

){
    Box (
        modifier = Modifier.fillMaxWidth().height(150.dp).
        background(color = colorResource(R.color.blue))
    ) {
        Row(
            modifier = Modifier.align(Alignment.Center).padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.back),
                contentDescription = null,
                modifier = Modifier.clickable {
                    onBackClick()
                }
            )
            Text(
                text = title+" Store Results",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.weight(1f).padding(horizontal = 16.dp),
                fontWeight = FontWeight.Bold
            )

            Image(
                painter = painterResource(R.drawable.sample),
                contentDescription = null
            )
        }
    }


}