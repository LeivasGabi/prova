package com.example.provakotlin.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.provakotlin.R
import com.example.provakotlin.adapter.Adapter
import com.example.provakotlin.model.Recipe
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.res_layout.*

class ListFragment : Fragment(R.layout.fragment_list) {

    private val args : ListFragmentArgs by navArgs()

    private lateinit var adapter: Adapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        populateItems()
        listRecipe()
        backFragment(view)

        //arg nao chega !!
        //como tava com problema eu ia tentar passar o args para o cardview, mas n rolou
        println(args.recipe)
    }

    private fun listRecipe() {
        textViewTitle.text = args.recipe.title
        textViewTitle.text = args.recipe.title
        textViewReceipeIngredients.text = args.recipe.ingredients
        textViewReceipePreparation.text = args.recipe.preparationMode
    }

    private fun populateItems() {
        adapter.setDataSet(listDataSet(args.recipe))
    }

    private fun listDataSet(recipe: Recipe) : List<Recipe>{
        return listOf(recipe)
    }

    private fun initAdapter() {
        adapter = Adapter { recipe ->
//            openDetails(args)
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

    }
//    private fun openDetails(){
//        val intent = Intent(findNavController().navigate(R.id.actionListToDetails))
//        startActivity(intent)
//    }
    private fun backFragment(view: View) {

        view.findViewById<Button>(R.id.btn_back).setOnClickListener {
            findNavController().navigate(R.id.actionListBackRegistraition)
        }
    }
}
