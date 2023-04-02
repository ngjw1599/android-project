package com.example.application

import android.os.Parcel
import android.os.Parcelable

// food id is only for the AR mode as translation will cause matching errors with the specified model
public final data class FoodItemClass(var foodID: String, var name:String, var photo:Int, var desc: String, var price:Float)