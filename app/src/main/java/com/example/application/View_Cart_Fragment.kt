package com.example.application

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class View_Cart_Fragment : Fragment() {

    // call the viewmodel class that holds the cart list
    private lateinit var cartListViewModel: CartViewModel

    // declare recyclerview
    private lateinit var newRecyclerView: RecyclerView

    private var totalPrice: Float? = null

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_cart, container, false)

        newRecyclerView = view.findViewById(R.id.CartItems)
        newRecyclerView.layoutManager = LinearLayoutManager(context)
        newRecyclerView.setHasFixedSize(true)
        var totalPriceView = view.findViewById<TextView>(R.id.totalPrice);
        // declare cart in here
        cartListViewModel = (activity as MainActivity).getCartListViewModel() as CartViewModel
        // if cart is empty, show message
        if (cartListViewModel.cartList.size == 0) {

        }
        // attach adapter to recyclerview to populate data
        newRecyclerView.adapter = cartAdapter(cartListViewModel.cartList, this)

        // call the cart items from the original main menu / promos
        if (cartListViewModel.cartList.size == 0){
            totalPriceView.text = "$0.00"
        }
        else {
            for (itemDetail in cartListViewModel.cartList) {
                totalPrice = totalPrice?.plus((itemDetail.price!! * itemDetail.itemAmount))
            }
            totalPriceView!!.text = "$ ${"%.2f".format(totalPrice)}"
        }


        // submit order on click and show order summary
        var submitOrderBtn = view.findViewById<Button>(R.id.confirmOrderButton)
        submitOrderBtn.setOnClickListener{
            if (totalPriceView.text == "$0.00"){
                submitOrderBtn.isClickable = false

            }
            else{
                val fm = childFragmentManager
                // make data transaction to fragment
                val fmTransact = fm.beginTransaction()
                // declare fragment you want to send

                val frag = OrderSummaryFragment()

                fmTransact.replace(R.id.cartFragment, frag)
                fmTransact.commit()

                // disable nav buttons or hide nav bar
                val navBar = (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottomNav)
                navBar.visibility = View.GONE

                // hide confirm order button
                submitOrderBtn.visibility = View.GONE


            }
        }

        return view
    }


    fun setTotalPrice(price: Float) {
        val totalPrice = view?.findViewById<TextView>(R.id.totalPrice)
        totalPrice!!.text = "$ ${"%.2f".format(price)}"
    }


}


