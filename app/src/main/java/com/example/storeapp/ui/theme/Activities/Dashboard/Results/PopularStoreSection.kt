package com.example.storeapp.ui.theme.Activities.Dashboard.Results

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.storeapp.Domain.StoreModel
import com.example.storeapp.R

@Composable
fun PopularStoreSection(
    stores : SnapshotStateList<StoreModel>
    , showPopularLoading:Boolean
){
    Row (
        modifier = Modifier.padding(horizontal = 16.dp).padding(top = 16.dp)
    ){
        Text(
            text = "Popular Stores",
            modifier = Modifier.weight(1f),
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold

        )
        Text(
            text = "See All",

            fontSize = 16.sp,
            color = Color.Black,
            style = TextStyle(
                textDecoration = TextDecoration.Underline
            )

        )
    }
    if(showPopularLoading){
        Box(
            modifier = Modifier.fillMaxSize().height(100.dp),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }else{
        LazyRow (
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy (12.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp)
        ){
            items (stores.size){
                index ->  Store(
                    item = stores[index],
                    onItemClick = {}
                )
            }
        }



    }
}


@Composable
fun Store(
    item: StoreModel,
    onItemClick: () -> Unit = {}
){
    val context = LocalContext.current
    Column (
        modifier = Modifier.padding(vertical = 8.dp).wrapContentSize()
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            .padding(8.dp).clickable{}
    ){
        AsyncImage(
            model = item.ImagePath,
            contentDescription = null,
            modifier = Modifier.size(135.dp,90.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(colorResource(R.color.grey),
                    shape = RoundedCornerShape(10.dp)
                    ),
            contentScale = ContentScale.Crop
        )

        Text(
            text = item.Title,
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 8.dp)
        )

        Row (
            Modifier.padding(top = 8.dp)
        ){
            Image(
                painter = painterResource(R.drawable.location),
                contentDescription = null
            )
            Text(
                text = item.ShortAddress,
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}