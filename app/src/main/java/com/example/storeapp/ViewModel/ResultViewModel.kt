package com.example.storeapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.storeapp.Domain.CategoryModel
import com.example.storeapp.Domain.StoreModel
import com.example.storeapp.Repository.ResultRepository

class ResultViewModel: ViewModel() {
    private val repository = ResultRepository()


    fun loadSubCategories(id:String): LiveData<MutableList<CategoryModel>>{
        return repository.loadSubCategories(id)
    }


    fun loadStores(id:String): LiveData<MutableList<StoreModel>>{
        return repository.loadPopular(id)
    }



    fun loadNearbyStores(id:String): LiveData<MutableList<StoreModel>>{
        return repository.loadNearest(id)
    }




}