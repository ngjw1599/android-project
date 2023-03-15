package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(){
    /*// declare recyclerview
    private lateinit var newRecyclerView: RecyclerView
    // declare list array
    private lateinit var newArrayList: ArrayList<FoodItemClass>

    lateinit var foodImageArray : Array<Int>
    private var foodNameArray = ArrayList<String>()
    private var foodDescArray = ArrayList<String>()
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val home = Home_Fragment()
        val promotion = Promotion_Fragment()
        val cart = View_Cart_Fragment()

        // shifted all main activity to another home fragment
        supportFragmentManager.beginTransaction().replace(R.id.framelayout, home).commit()

        // navigation of the bottom nav bar
        val btmnav = findViewById<BottomNavigationView>(R.id.bottomNav)
        btmnav.setOnNavigationItemSelectedListener() {
            // itemid is the id being set in the nav_menu.xml
            when (it.itemId) {
                R.id.ic_home ->
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout, home)
                        .commit()
                R.id.ic_promo ->
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout, promotion).commit()
                R.id.ic_checkout ->
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout, cart)
                        .commit()
            }
            true
        }


/*
        //set up file to scan
        val scanner = Scanner(resources.openRawResource(R.raw.menu))
        readFile(scanner)

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

        val home = MainActivity()
        // fragment
        val promotion = Promotion_Fragment()
        val cart = View_Cart_Fragment()

        // navigation of bar
        val btmnav = findViewById<BottomNavigationView>(R.id.bottomNav)
        btmnav.setOnNavigationItemSelectedListener(){
            // itemid is the id being set in the nav_menu.xml
            when (it.itemId){
                R.id.ic_promo ->
                    supportFragmentManager.beginTransaction().replace(R.id.constraintLayout, promotion).commit()
                R.id.ic_checkout ->
                    supportFragmentManager.beginTransaction().replace(R.id.constraintLayout, cart).commit()
            }
            true
        }


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

    }*/


    }



}