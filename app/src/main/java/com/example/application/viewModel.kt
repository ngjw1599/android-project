package com.example.application

import androidx.lifecycle.ViewModel

class CartViewModel: ViewModel() {
    val cartList = mutableListOf<CartClass>()

}