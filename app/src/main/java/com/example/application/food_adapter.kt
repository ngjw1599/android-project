package com.example.application

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class foodAdapter(private val foodList: ArrayList<FoodItem>):
    RecyclerView.Adapter<foodAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val foodtextView = itemView.findViewById<TextView>(R.id.foodName)
        val foodPhoto = itemView.findViewById<ImageView>(R.id.foodImage)

    }

    //https://guides.codepath.com/android/using-the-recyclerview

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): foodAdapter.MyViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.menucard_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        // returns the size of the hashmap
        return foodList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = foodList[position]
        holder.foodPhoto.setImageResource(currentItem.photo)
        holder.foodtextView.text = currentItem.name

    }

}