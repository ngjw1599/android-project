package com.example.application

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class OrderSummaryFragment : Fragment() {

    private lateinit var orderListViewModel: CartViewModel
    // declare recyclerview
    private lateinit var newRecyclerView: RecyclerView
    private var totalPrice: Float? = null

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order_summary, container, false)

        newRecyclerView = view.findViewById(R.id.OrderItems)
        newRecyclerView.layoutManager = LinearLayoutManager(context)
        newRecyclerView.setHasFixedSize(true)
        var totalPriceView = view.findViewById<TextView>(R.id.totalPrice)

        // declare cart in here
        orderListViewModel = (activity as MainActivity).getCartListViewModel() as CartViewModel

        // attach adapter to recyclerview to populate data
        newRecyclerView.adapter = OrderAdapter(orderListViewModel.cartList, this)

        // call the cart items from the original main menu / promos
        if (orderListViewModel.cartList.size == 0){
            totalPriceView.text = "$0.00"
        }
        else{
            for (itemDetail in orderListViewModel.cartList){
                totalPrice = totalPrice?.plus((itemDetail.price!! * itemDetail.itemAmount))
            }
            totalPriceView!!.text = "$ ${"%.2f".format(totalPrice)}"
        }

        // back to homepage button on click and clear cart
        val goHomeBtn = view.findViewById<Button>(R.id.goHomeButton)
        goHomeBtn.setOnClickListener{
            val fm = childFragmentManager
            // make data transaction to fragment
            val fmTransact = fm.beginTransaction()
            // declare fragment you want to send

            val frag = Home_Fragment()

            fmTransact.replace(R.id.orderSummaryFragment, frag)
            fmTransact.commit()
            orderListViewModel.cartList.clear()
            // hide confirm order button
            goHomeBtn.visibility = View.GONE

            // make nav bar visible again
            val navBar = (activity as MainActivity).findViewById<BottomNavigationView>(R.id.bottomNav)
            navBar.visibility = View.VISIBLE


        }

        return view
    }

    fun setTotalPrice(price: Float) {
        val totalPrice = view?.findViewById<TextView>(R.id.totalPrice)
        totalPrice!!.text = "$ ${"%.2f".format(price)}"
    }



}