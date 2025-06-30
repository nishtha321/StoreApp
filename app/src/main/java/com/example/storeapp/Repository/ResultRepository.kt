package com.example.storeapp.Repository

import androidx.compose.runtime.snapshots.Snapshot
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.storeapp.Domain.CategoryModel
import com.example.storeapp.Domain.StoreModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class ResultRepository {

    private  val firebaseDatabase = FirebaseDatabase.getInstance()

    fun loadSubCategories(
        id:String
    ): LiveData<MutableList<CategoryModel>> {
        val listDta = MutableLiveData<MutableList<CategoryModel>>()
        val ref = firebaseDatabase.getReference("SubCategory")
         val query : Query=ref.orderByChild("CategoryId").equalTo(id)

        query.addListenerForSingleValueEvent(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot){
                val lists = mutableListOf<CategoryModel>()
                for(childSnapShot in snapshot.children){
                    val list = childSnapShot.getValue(CategoryModel::class.java)
                    if(list != null){
                        lists.add(list)
                    }
                }
                listDta.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return listDta
    }



    fun loadPopular(
        id:String
    ): LiveData<MutableList<StoreModel>> {
        val listDta = MutableLiveData<MutableList<StoreModel>>()
        val ref = firebaseDatabase.getReference("Stores")
        val query : Query=ref.orderByChild("CategoryId").equalTo(id)

        query.addListenerForSingleValueEvent(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot){
                val lists = mutableListOf<StoreModel>()
                for(childSnapShot in snapshot.children){
                    val list = childSnapShot.getValue(StoreModel::class.java)
                    if(list != null){
                        lists.add(list)
                    }
                }
                listDta.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return listDta
    }



    fun loadNearest(
        id:String
    ): LiveData<MutableList<StoreModel>> {
        val listDta = MutableLiveData<MutableList<StoreModel>>()
        val ref = firebaseDatabase.getReference("Nearest")
        val query : Query=ref.orderByChild("CategoryId").equalTo(id)

        query.addListenerForSingleValueEvent(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot){
                val lists = mutableListOf<StoreModel>()
                for(childSnapShot in snapshot.children){
                    val list = childSnapShot.getValue(StoreModel::class.java)
                    if(list != null){
                        lists.add(list)
                    }
                }
                listDta.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        return listDta
    }
}