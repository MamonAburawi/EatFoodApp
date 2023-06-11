package com.mamon.eatfoodapp.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mamon.eatfoodapp.data.Category
import com.mamon.eatfoodapp.data.CombinedData
import com.mamon.eatfoodapp.data.Food
import com.mamon.eatfoodapp.utils.categoryList
import com.mamon.eatfoodapp.utils.foodList
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {


    private val _categories = MutableLiveData<List<Category>>(categoryList)
    val categories: LiveData<List<Category>> = _categories


    private val _foods = MutableLiveData<List<Food>>(foodList)
    val foods: LiveData<List<Food>> =  _foods


    private val _combinedLiveData = MutableLiveData<CombinedData>()
    val combinedLiveData: LiveData<CombinedData> = _combinedLiveData


    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            val categoriesDeferred = async { fetchCategories() }
            val foodsDeferred = async { fetchFoods() }

            // here you will wait until all data fetched then combined Live Data will be updated
            val brands = categoriesDeferred.await()
            val products = foodsDeferred.await()

            _categories.value = brands
            _foods.value = products

            val combinedData = CombinedData(brands, products)
            _combinedLiveData.value = combinedData
        }
    }


    private suspend fun fetchCategories(): List<Category> {
        // Fetch data1 asynchronously
        // ..
        delay(500)
        return categoryList
    }

    private suspend fun fetchFoods(): List<Food> {
        // Fetch data2 asynchronously
        // ...
        return foodList
    }






}