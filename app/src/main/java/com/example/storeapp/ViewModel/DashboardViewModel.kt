package com.example.storeapp.ViewModel

import androidx.lifecycle.LiveData
import com.example.storeapp.Domain.CategoryModel

class DashboardViewModel {

    private val repository = DashboardViewModel()
    fun loadCategory(): LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }
}