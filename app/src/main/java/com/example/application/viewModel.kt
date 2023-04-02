package com.example.application

import androidx.lifecycle.ViewModel

class CartViewModel: ViewModel() {
    var cartList = mutableListOf<CartClass>()

}