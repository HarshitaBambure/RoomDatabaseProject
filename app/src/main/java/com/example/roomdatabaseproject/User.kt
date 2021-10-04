package com.example.roomdatabaseproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name = "product_name")val product_name:String,
    @ColumnInfo(name = "price_name")val price_name:String,
    @ColumnInfo(name = "photo_product")val photo_product:String,

){
    @PrimaryKey(autoGenerate = true)var uid: Int? = null
}