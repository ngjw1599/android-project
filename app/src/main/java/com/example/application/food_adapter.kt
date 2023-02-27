package com.example.application

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class food_adapter(private val foodList:HashMap<String,String>): RecyclerView.Adapter<food_adapter.MyViewHolder> {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    //https://guides.codepath.com/android/using-the-recyclerview

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        // returns the size of the hashmap
        return foodList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}