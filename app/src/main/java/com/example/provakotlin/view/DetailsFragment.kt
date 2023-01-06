package com.example.provakotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.provakotlin.R

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailsRecipe(view)
        backFragment(view)
    }

    private fun backFragment(view: View) {

        view.findViewById<Button>(R.id.btn_back).setOnClickListener {
            findNavController().navigate(R.id.actionDetailsBackList)
        }

    }

    private fun detailsRecipe(view: View) {

        view.findViewById<TextView>(R.id.textViewReceipeTitle).text = args.recipe.title
        view.findViewById<TextView>(R.id.textViewReceipeIngredients).text = args.recipe.ingredients
        view.findViewById<TextView>(R.id.textViewReceipePreparation).text = args.recipe.preparationMode

    }

}