package com.example.storeapp.ui.theme.Activities.Dashboard.Results

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.storeapp.Domain.CategoryModel
import com.example.storeapp.Domain.StoreModel
import com.example.storeapp.R
import com.example.storeapp.ViewModel.ResultViewModel

class ResultsActivity : AppCompatActivity() {
    private var id : String = ""
    private var title : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        id = intent.getStringExtra("id") ?: ""
        title = intent.getStringExtra("title")?: ""

        setContent {

            ResultList(id,title,onBackClick={finish()})

        }
    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Composable
@Preview
fun ResultList(id:String = "1",title:String = "", onBackClick: () -> Unit = {}){

    val  viewModel = ResultViewModel()

    val subCategory = remember { mutableStateListOf<CategoryModel>() }
    val popularStores = remember { mutableStateListOf<StoreModel>() }
    val nearStores = remember { mutableStateListOf<StoreModel>() }



    var showCategoryLoading by remember { mutableStateOf(true) }
    var showPopularLoading by remember { mutableStateOf(true) }
    var showNearLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        viewModel.loadSubCategories(id).observeForever {
            subCategory.clear()
            subCategory.addAll(it)
            showCategoryLoading = false
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadStores(id).observeForever {
            popularStores.clear()
            popularStores.addAll(it)
            showPopularLoading = false
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadNearbyStores(id).observeForever {
            nearStores.clear()
            nearStores.addAll(it)
            showNearLoading = false
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize().background(color = colorResource(R.color.lightBlue))
    ){
        item { TopTitle(title,onBackClick) }
        item { Search() }
        item { SubCategorySection(subCategory,showCategoryLoading) }
        item { PopularStoreSection(popularStores,showPopularLoading) }
        item { NearestSection(nearStores,showNearLoading) }
    }
}
