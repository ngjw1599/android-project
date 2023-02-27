package com.example.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    // declare hashmap
    private var foodmap= HashMap<String,String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    // scanner
    //
    private fun readFile(scanner: Scanner){
        while (scanner.hasNextLine()){
            val line= scanner.nextLine()
            val food_detail = line.split("\t")
            // hashmap to make key:value pair
            foodmap[food_detail[0]] = food_detail[1]
        }
    }



}