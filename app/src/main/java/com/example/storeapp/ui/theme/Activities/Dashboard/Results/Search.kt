package com.example.storeapp.ui.theme.Activities.Dashboard.Results

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.storeapp.R

@Composable
@Preview
fun Search(){

    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {text = it},
        label = {
            Text(text = "Find Stories, resturants, products, etc.",
                fontSize = 12.sp,
                color = Color.Black
                )
        },
        shape = RoundedCornerShape(10.dp),
        leadingIcon = {
            Image(
                painter = painterResource(R.drawable.search_icon),
                contentDescription = null,
                modifier = Modifier.size(22.dp)
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = colorResource(R.color.white),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            textColor = Color.DarkGray,
            unfocusedLabelColor = Color.Transparent
        ),
        modifier = Modifier.fillMaxWidth().padding(16.dp).height(50.dp).background(color = colorResource(R.color.grey), shape = RoundedCornerShape(10.dp))
    )
}