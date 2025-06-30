package com.example.storeapp.ui.theme.Activities.Dashboard

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.storeapp.Domain.CategoryModel
import com.example.storeapp.R
import com.example.storeapp.ui.theme.Activities.Dashboard.Results.ResultsActivity
import okhttp3.internal.cache.DiskLruCache
import java.nio.file.WatchEvent


@Composable

fun CategorySection(
    categoryModel: SnapshotStateList<CategoryModel>,
    showCategoryLoading: Boolean
){
   Text(
       text = "Emplore Stores",
       fontWeight = FontWeight.SemiBold,
       fontSize = 20.sp,
       modifier = Modifier.padding(horizontal = 16.dp).padding(top = 24.dp)
   )

    if(showCategoryLoading){
     Box(
         modifier = Modifier.fillMaxWidth().height(200.dp),
         contentAlignment = Alignment.Center
        ){
         CircularProgressIndicator()
        }

    }else{
       val rows = categoryModel.chunked(3)
        val context = LocalContext.current

        Column (
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ){
            rows.forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    row.forEach { category ->
                        CategoryItem(
                            categoryModel = category,
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 8.dp),
                            onItemClick = {

                                val intent = Intent(
                                    context,
                                    ResultsActivity::class.java
                                ).apply {
                                    putExtra(
                                        "id",category.Id.toString(),

                                    )
                                    putExtra(
                                        "title",category.Name
                                    )
                                }
                                context.startActivity(intent,null)
                                // Handle click
                            }
                        )
                    }
                    // fill empty slots if this row < 3
                    repeat(3 - row.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }

                }

            }


        }

    }




}

@Composable
fun CategoryItem(
    categoryModel: CategoryModel,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    Column(
        modifier = modifier // << use the passed modifier
            .background(
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(13.dp)
            )
            .clickable(onClick = onItemClick)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = categoryModel.ImagePath,
            contentDescription = null,
            modifier = Modifier.size(65.dp)
        )

        Text(
            text = categoryModel.Name,
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
