package hash.application.dataType

import java.util.ArrayList

/**
 * Created by gouji on 3/18/2018.
 */
class Recipes {
    val recipes: ArrayList<Recipe> = ArrayList()

    fun findRecipe(){
        //TODO
    }

    fun addRecipe(){
        //TODO
    }

    fun resetRecipes(){
        //TODO
    }

    data class Recipe(
            val name: String,
            val id: String,
            val totaltime: Int,
            val imageURL: String,
            val numberofserving: Int,
            val flavor: String,
            val instructionurl: String,
            val ingredient: ArrayList<String>
    )
}

