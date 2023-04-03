package com.example.application

import android.os.Parcel
import android.os.Parcelable

// food id is only for the AR mode as translation will cause matching errors with the specified model
// AR will only match against the first 4 food menu items for demo purposes, the rest will be attached to "chicken rice" model.
public final data class FoodItemClass(var foodID: String, var name:String, var photo:Int, var desc: String, var price:Float)