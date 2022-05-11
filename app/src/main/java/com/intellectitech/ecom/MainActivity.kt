package com.intellectitech.ecom

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainActivity : AppCompatActivity() {
    //a list to store all the products
    var productList: MutableList<Product>? = null

    //the recyclerview
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getting the recyclerview from xml
        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(this)

        //initializing the productlist
        productList = ArrayList<Product>()


        //adding some items to our list
        (productList as ArrayList<Product>).add(
            Product(
                1,
                "Apple iPhone 11",
                "6.1 inches, Color black 828 x 1792 pixels",
                4.8,
                90000,
                R.drawable.apple))
        (productList as ArrayList<Product>).add(
            Product(
                1,
                "Galaxy A12",
                "2.3GHz, 1.8GHz CPU, multi color, 205 kg",
                4.1,
                55000,
                R.drawable.samsung))
        (productList as ArrayList<Product>).add(
            Product(
                1,
                "Oppo F17",
                "6.44 inch, Color Peach, 6GB RAM , 163  kg",
                4.6,
                47000,
                R.drawable.oddo))

        //creating recyclerview adapter
        val adapter = ProductAdapter(this, productList as ArrayList<Product>)

        //setting adapter to recyclerview
        recyclerView!!.adapter = adapter
    }
}