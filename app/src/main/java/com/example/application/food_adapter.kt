package com.example.application

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.Filter
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.application.java.augmentedimage.AugmentedImageActivity
import java.util.*
import kotlin.collections.ArrayList


class foodAdapter(private var foodList: ArrayList<FoodItemClass>,
    private val listener: OnItemClickListener, private val fragment: String, private val activity: AppCompatActivity, private val context: Context
):
    RecyclerView.Adapter<foodAdapter.MyViewHolder>(){

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val foodtextView = itemView.findViewById<TextView>(R.id.foodName)
        val foodPhoto = itemView.findViewById<ImageView>(R.id.foodImage)

        // cart button
        val foodCart = itemView.findViewById<Button>(R.id.cart_button)

        val ARButton = itemView.findViewById<Button>(R.id.AR_button)

        init{
            foodCart.setOnClickListener(this)

         if (fragment == "Promotion_Fragment"){
                ARButton!!.visibility = View.INVISIBLE
            }
            else{
                ARButton.visibility = View.VISIBLE
                ARButton.setOnClickListener {
                    val myIntent = Intent(context, AugmentedImageActivity::class.java)
                    myIntent.putExtra("foodID", foodList[absoluteAdapterPosition].foodID)
                    context.startActivity(myIntent)
                }
            }



        }
        override fun onClick(v: View?) {
            // gets the current position of item we want to see
            val position = absoluteAdapterPosition
            val image = foodList[position].photo
            val name = foodList[position].name
            val desc = foodList[position].desc
            val price = foodList[position].price

            // uses the current position details to pass data into the item detail page
            if (position != RecyclerView.NO_POSITION){
                listener.passData(position,image,name,desc,price)
            }

        }

    }
    // on button click it will go to each item detail page
    interface OnItemClickListener{
        fun passData(position: Int, image: Int, name: String, desc: String, price: Float)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): foodAdapter.MyViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.menucard_item, parent, false)
        itemView.clipToOutline = true
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        // returns the size of the array for recyclerview to determine number of items needed
        return foodList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = foodList[position]
        holder.foodPhoto.setImageResource(currentItem.photo)
        holder.foodtextView.text = currentItem.name
    }

    // searchbar for filtering
    fun setFilterText(filteredfoodList: ArrayList<FoodItemClass>){
        this.foodList = filteredfoodList
        notifyDataSetChanged()
    }






}