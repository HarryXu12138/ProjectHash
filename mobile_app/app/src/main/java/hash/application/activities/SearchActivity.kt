package hash.application.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import hash.application.R
import hash.application.dataType.Recipe
import hash.application.helpers.CustomRecipeAdapter
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }

    override fun onStart() {
        super.onStart()
        val json = intent.extras.getString("json")//get json string sent from intent

        val recipes: ArrayList<Recipe>
        recipes = try {
            ArrayList(Gson().fromJson(json, Array<Recipe>::class.java).toList())
        } catch (e: Exception) {
            ArrayList()//in case json str is empty or faulty
        }
        if (recipes == null) {
            Log.e("log_SearchActivity", "recipes is null")
            throw Exception("recipes is null")
        }
        val adapter = CustomRecipeAdapter(this, recipes)
        listView1.adapter = adapter//attach the custom adapter on the listview
        //the reaction when click items in listview
        listView1.setOnItemClickListener { _, _, position, _ ->
            val recipe: Recipe = adapter.getItem(position)//get the item clicked one
            val intent = Intent(this, ViewDish::class.java)//setup the activity to open
            val bundle = recipe.getRecipeBundle()
            intent.putExtra("data", bundle)//put the json data into intent, can be accessed after the activity opened
            startActivity(intent)//open the activity
        }
    }
}