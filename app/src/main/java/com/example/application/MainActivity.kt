package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    // declare recyclerview
    private lateinit var newRecyclerView: RecyclerView
    // declare list array
    private lateinit var newArrayList: ArrayList<FoodItem>

    lateinit var foodImageArray : Array<Int>
    lateinit var foodNameArray : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set array for images


        // set array for food names
        //Croissant, Hamburger, Chocolate Cake, Soup, Muffin
        foodImageArray = arrayOf(
            R.drawable.chocolatecake,
            R.drawable.croissant,
            R.drawable.hamburger,
            R.drawable.soup,
            R.drawable.muffin
        )

        foodNameArray = arrayOf(
            "Chocolate Cake",
            "Croissant",
            "Hamburger",
            "Soup",
            "Muffin"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<FoodItem>()
        getItemData()


    }

    private fun getItemData(){
        for (i in foodImageArray.indices){
            val fooditem = FoodItem(foodNameArray[i], foodImageArray[i])
            newArrayList.add(fooditem)
        }

        newRecyclerView.adapter = foodAdapter(newArrayList)
    }

    // scanner
    // to change and place in food array
    /*private fun readFile(scanner: Scanner){
        while (scanner.hasNextLine()){
            val line= scanner.nextLine()
            val food_detail = line.split("\t")
            // hashmap to make key:value pair
            foodmap[food_detail[0]] = food_detail[1]
        }
    }*/



}