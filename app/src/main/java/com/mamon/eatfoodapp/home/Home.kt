package com.mamon.eatfoodapp.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mamon.eatfoodapp.data.Category
import com.mamon.eatfoodapp.data.Food
import com.mamon.eatfoodapp.databinding.HomeBinding
import com.mamon.eatfoodapp.utils.showMessage

class Home : Fragment() {

    private lateinit var binding: HomeBinding
    private lateinit var viewModel: HomeViewModel
    private  val homeController by lazy { HomeController() }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = HomeBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        setViews()
        setObserves()

        return binding.root
    }

    private fun setObserves() {
        viewModel.apply {

            // live data
            combinedLiveData.observe(viewLifecycleOwner){
                if (it != null){
                    homeController.putData(it.categories + it.foods)
                }
            }


        }
    }

    private fun setViews() {
        setButtons()
        setHomeAdapter()
    }


    private fun setHomeAdapter() {
        homeController.clickListener = object: HomeController.OnClickListener{
            override fun onCategoryClicked(category: Category) {
                showMessage(category.name)
            }

            override fun onFoodClicked(food: Food) {
               showMessage(food.name)
            }

        }
        binding.rvHome.adapter = homeController.adapter
    }


    private fun setButtons() {
        binding.apply {

            /** button menu **/
            btnMenu.setOnClickListener {
                showMessage("menu")
            }


            /** button account **/
            btnAccount.setOnClickListener {
                showMessage("account")
            }


            /** button shop **/
            btnShop.setOnClickListener {
                showMessage("shop")
            }

        }
    }


}