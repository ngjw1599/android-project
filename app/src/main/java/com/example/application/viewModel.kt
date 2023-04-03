package com.example.application

import androidx.lifecycle.ViewModel

// viewmodel to attach as global variable, declared in activity
class CartViewModel: ViewModel() {
    var cartList = mutableListOf<CartClass>()

}