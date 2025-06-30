package com.example.storeapp.Domain

import java.io.Serializable

data class StoreModel(
    var Id: Int = 0,
    var CategoryId: String = "",
    var Title: String = "",
    var Latitide: Double = 0.0,
    var Longitude: Double = 0.0,
    var Call: String = "",
    var Address: String = "",
    var Activity : String = "",
    var ShortAddress: String = "",
    var ImagePath: String = "",
    var Hours: String = "",
) : Serializable
