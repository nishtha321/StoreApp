package com.example.storeapp.ui.theme.Activities.Dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.storeapp.Domain.BannerModel
import com.example.storeapp.Domain.CategoryModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState


@OptIn(ExperimentalPagerApi::class)
@Composable

fun Banner(
    bannerModel:  SnapshotStateList<BannerModel>,
    showBannerLoading: Boolean
){
    if(showBannerLoading){
        Box(
            modifier = Modifier.fillMaxSize().height(200.dp),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }else{

        Sliding(
            banners = bannerModel,
        )

    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Sliding(
  pagerState: PagerState = remember { PagerState() },

  banners:List<BannerModel>
) {

    com.google.accompanist.pager.HorizontalPager(
        count = banners.size,
        state = pagerState
    ) { page ->
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(banners[page].image).build(),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize().padding(16.dp).clip(shape = RoundedCornerShape(10.dp)).height(150.dp)
        )
    }
}
