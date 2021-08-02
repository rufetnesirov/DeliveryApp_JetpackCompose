package com.example.deliveryapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.deliveryapp.R
import com.example.deliveryapp.designs.*
import com.example.deliveryapp.ui.theme.DeliveryAppTheme
import com.example.deliveryapp.utils.recipe_list.getAllFoodCategoriesValue
import com.example.deliveryapp.viewmodels.HomeActivityViewModel
import com.example.deliveryapp.viewmodels.SelectedCategoryViewModel

class RecipeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {

            var viewModelProvider =
                ViewModelProvider(requireActivity()).get(HomeActivityViewModel::class.java)
            var selectedCategoryViewModel =
                ViewModelProvider(requireActivity()).get(SelectedCategoryViewModel::class.java)
            viewModelProvider.query.value = selectedCategoryViewModel.selectedCategory.value

            setContent {

                DeliveryAppTheme {

                    Column(modifier = Modifier.fillMaxSize()) {

                        TopAppBar(
                            title = "Zardab Foods",
                            icon = painterResource(id = R.drawable.icon),
                            isMenuOn = true
                        )

                        TextFieldDesign(onClick = { text, _ ->
                            viewModelProvider.query.value = text
                            viewModelProvider.resetSearchState()
                        })
                        Spacer(modifier = Modifier.height(5.dp))
                        MenuList(
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .fillMaxWidth(),
                            menuList = getAllFoodCategoriesValue(),
                            selectedCategoryViewModel,
                            homeViewModel = viewModelProvider
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        val deliveryList = viewModelProvider.deliveryList.value

                        val page = viewModelProvider.page.value

                        deliveryList?.let { recipes ->
                            FoodList(
                                recipes = recipes,
                                modifier = Modifier.padding(horizontal = 10.dp),
                                page = page,
                                viewModelProvider = viewModelProvider,
                                onCLickItem = { recipeID ->
                                    val bundle = Bundle()
                                    bundle.putInt("recipeID", recipeID)
                                    findNavController().navigate(R.id.viewRecipeDetail, bundle)
                                }
                            )
                        }

                    }
                }

            }
        }
    }
}