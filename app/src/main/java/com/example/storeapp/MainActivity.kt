package com.example.storeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.storeapp.Domain.CategoryModel
import com.example.storeapp.ViewModel.DashboardViewModel
import com.example.storeapp.ui.theme.Activities.Dashboard.BottomBar
import com.example.storeapp.ui.theme.Activities.Dashboard.TopBar
import com.example.storeapp.ui.theme.StoreAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           DashboardScreen()
        }
    }
}

@Composable
@Preview
fun DashboardScreen(){
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = colorResource(id = R.color.blue)
    )

  val viewModel = DashboardViewModel()
    val categories = remember {
        mutableStateListOf<CategoryModel>()
    }

    var showLoading by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {
        viewModel.loadCategory().observeForever {
            categories.clear()
            categories.addAll(it)
            showLoading = false
        }
    }


    Scaffold (
        bottomBar = { BottomBar() }
    ){
        paddingValues ->

        LazyColumn (
            modifier = Modifier.fillMaxSize().background(color = colorResource(R.color.lightBlue)).padding(
                paddingValues = paddingValues
            )
        ){
            item {
                TopBar()
            }
        }
    }
}

