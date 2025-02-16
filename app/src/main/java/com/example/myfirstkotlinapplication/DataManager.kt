package com.example.myfirstkotlinapplication

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class DataManager(app: Application) : AndroidViewModel(app) {
    var menu: List<Category> by mutableStateOf(listOf())
    var cart: List<ItemInCart> by mutableStateOf(listOf())

    fun fetchData(){
        viewModelScope.launch {
            menu = API.menuService.fetchMenu()
        }
    }
    init {
        fetchData()
    }

    fun addCart(){}


    fun cartRemove(product: Product) {
        cart = cart.filter { it.product.id != product.id }
    }

    fun cartClear() {
        cart = emptyList()
    }

    fun cartTotal(){}
}