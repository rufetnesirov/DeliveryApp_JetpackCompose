package com.example.deliveryapp.models.receipes

data class RecipeResponse(
	val instructions: String? = null,
	val sustainable: Boolean? = null,
	val analyzedInstructions: List<AnalyzedInstructionsItem?>? = null,
	val glutenFree: Boolean? = null,
	val veryPopular: Boolean? = null,
	val healthScore: Int? = null,
	val title: String? = null,
	val diets: List<String?>? = null,
	val aggregateLikes: Int? = null,
	val creditsText: String? = null,
	val readyInMinutes: Int? = null,
	val sourceUrl: String? = null,
	val dairyFree: Boolean? = null,
	val servings: Int? = null,
	val vegetarian: Boolean? = null,
	val id: Int? = null,
	val imageType: String? = null,
	val winePairing: WinePairing? = null,
	val summary: String? = null,
	val image: String? = null,
	val veryHealthy: Boolean? = null,
	val vegan: Boolean? = null,
	val cheap: Boolean? = null,
	val extendedIngredients: List<ExtendedIngredientsItem?>? = null,
	val dishTypes: List<String?>? = null,
	val gaps: String? = null,
	val cuisines: List<Any?>? = null,
	val lowFodmap: Boolean? = null,
	val weightWatcherSmartPoints: Int? = null,
	val occasions: List<Any?>? = null,
	val spoonacularScore: Int? = null,
	val pricePerServing: Double? = null,
	val sourceName: String? = null,
	val originalId: Any? = null
)