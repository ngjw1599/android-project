package com.example.application

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter(private val cartList: MutableList<CartClass>, private val fragment: OrderSummaryFragment): RecyclerView.Adapter<OrderAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val foodTextView = itemView.findViewById<TextView>(R.id.cartFoodItem)
        val priceTextView = itemView.findViewById<TextView>(R.id.cartFoodPrice)
        val amountTextView = itemView.findViewById<TextView>(R.id.cartFoodAmount)
        var totalItemPriceView = itemView.findViewById<TextView>(R.id.totalItemPrice);


        init{
            fragment.setTotalPrice(totalPriceCalculate())

        }

    }

    // inflate in cart list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.orderlist_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = cartList[position]
        holder.foodTextView.text = currentItem.name
        // toString the ones with non text values
        holder.priceTextView.text = "$ ${"%.2f".format(currentItem.price)}"
        holder.amountTextView.text = currentItem.itemAmount.toString()
        holder.totalItemPriceView.text = "$ ${"%.2f".format(currentItem.itemAmount.toFloat() * currentItem.price!!)}"

    }

    private fun totalPriceCalculate(): Float {
        // declare total price as a float
        var totalPrice = 0.0f
        if (cartList.size == 0){
            totalPrice = 0F
        }
        else{
            for (itemDetail in cartList){
                totalPrice += (itemDetail.price!! * itemDetail.itemAmount)
            }
        }

        return totalPrice
    }
}