package com.example.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), foodAdapter.OnItemClickListener {
    // declare recyclerview
    private lateinit var newRecyclerView: RecyclerView
    // declare list array
    private lateinit var newArrayList: ArrayList<FoodItemClass>

    lateinit var foodImageArray : Array<Int>
    private var foodNameArray = ArrayList<String>()
    private var foodDescArray = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //set up file to scan
        val scanner = Scanner(resources.openRawResource(R.raw.menu))
        readFile(scanner)

        // set array for food names and images
        //Croissant, Hamburger, Chocolate Cake, Soup, Muffin
        foodImageArray = arrayOf(
            R.drawable.chocolatecake,
            R.drawable.croissant,
            R.drawable.hamburger,
            R.drawable.soup,
            R.drawable.muffin
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<FoodItemClass>()
        getItemData()


    }

    private fun getItemData(){
        for (i in foodImageArray.indices){
            val fooditem = FoodItemClass(foodNameArray[i], foodImageArray[i], foodDescArray[i])
            newArrayList.add(fooditem)
        }
        // attach adapter to recyclerview to populate data
        newRecyclerView.adapter = foodAdapter(newArrayList, this)

    }

    // scanner
    // to change and place in food array
    private fun readFile(scanner: Scanner){
        while (scanner.hasNextLine()){
            val line= scanner.nextLine()
            val pieces = line.split("\t")
            // add food name and description accordingly
            foodNameArray.add(pieces[0])
            foodDescArray.add(pieces[1])
        }
    }

    override fun passData(position: Int, image: Int, name: String, desc: String) {
        // declaring fragment manager
        val fm = supportFragmentManager
        // make data transaction to fragment
        val fmTransac = fm.beginTransaction()
        // declare fragment you want to send
        val frag = FoodItem_Fragment()
        val bundle = Bundle()
        bundle.putInt("input_position", position)
        bundle.putInt("input_image", image)
        bundle.putString("input_name", name)
        bundle.putString("input_desc", desc)
        frag.arguments = bundle

        fmTransac.replace(R.id.constraintLayout, frag)
        fmTransac.addToBackStack(null)
        fmTransac.commit()

    }



}