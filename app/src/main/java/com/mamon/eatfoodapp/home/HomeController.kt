package com.mamon.eatfoodapp.home

import android.util.Log
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.TypedEpoxyController
import com.mamon.eatfoodapp.CategoryBindingModel_
import com.mamon.eatfoodapp.FoodBindingModel_
import com.mamon.eatfoodapp.HeaderBindingModel_
import com.mamon.eatfoodapp.data.Category
import com.mamon.eatfoodapp.data.Food
import com.mamon.eatfoodapp.header
import com.mamon.eatfoodapp.spaceModel
import com.mamon.eatfoodapp.utils.SpaceModel_
import com.mamon.eatfoodapp.utils.categoryList


class HomeController : TypedEpoxyController<List<Any>>() {

    private var categories: List<Category> = emptyList()
    private var foods: List<Food> = emptyList()

    lateinit var clickListener: OnClickListener

    fun putData(list: List<Any>) {
        categories = list.filterIsInstance<Category>()
        foods = list.filterIsInstance<Food>()
        setData(list)
    }

    override fun buildModels(list: List<Any>?){
        createBrandModels()

        add(SpaceModel_()
            .id("space")
            .height(140))

        createProductModels()
    }


    private fun createBrandModels() {

        header {
            id("category_header")
            title("Categories")
        }

        val categoryModels = categories.map { category ->
            CategoryBindingModel_()
                .id(category.id)
                .category(category)
                .onItemClicked { v->
                    clickListener.onCategoryClicked(category)
                }
        }

        // the data will be set in horizontal
        CarouselModel_()
            .id("category_carousel")
            .models(categoryModels)
            .addTo(this)

    }


    private fun createProductModels() {

        header {
            id(2L)
            title(categoryList.first().name)
        }

        val foodModels = foods.map { food ->
            FoodBindingModel_()
                .id(food.id)
                .food(food)
                .onItemClicked {v->
                    clickListener.onFoodClicked(food)
                }
        }

        // the data will be set in horizontal
        CarouselModel_()
            .id("food_carousel")
            .models(foodModels)
            .addTo(this)

    }

    interface OnClickListener {
        fun onCategoryClicked(category: Category)
        fun onFoodClicked(food: Food)
    }

}
