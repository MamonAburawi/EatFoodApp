package com.mamon.eatfoodapp.utils

import com.mamon.eatfoodapp.R
import com.mamon.eatfoodapp.data.Category
import com.mamon.eatfoodapp.data.Food

val foodList = arrayListOf(
    Food("1","Veggie Pizza",R.drawable.pizza_1,2.5f,25f),
    Food("2","Pepperoni Pizza",R.drawable.pizza_2,3.0f,12f),
    Food("3","Meat Pizza",R.drawable.pizza_3,3.5f,20f),
    Food("4","Margherita Pizza",R.drawable.pizza_4,1.0f,10f),
    Food("5","Hawaiian Pizza",R.drawable.pizza_5,4.5f,5f)
)

val categoryList = arrayListOf(
    Category("1","Hamburger", R.drawable.ic_hamburger) ,
    Category("2","Pizza", R.drawable.ic_pizza),
    Category("3","Chicken", R.drawable.ic_chicken)
)


