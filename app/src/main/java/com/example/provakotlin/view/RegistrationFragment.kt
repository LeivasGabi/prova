package com.example.provakotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.provakotlin.R
import com.example.provakotlin.model.Recipe

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newRecipe(view)
    }

    private fun newRecipe(view: View) {
        val title = view.findViewById<EditText>(R.id.editTextTitle)
        val ingredients = view.findViewById<EditText>(R.id.editTextIngredients)
        val preparationMode = view.findViewById<EditText>(R.id.editTextPreparationMode)

        val recipe = Recipe(
            title = title.text.toString(),
            ingredients = ingredients.text.toString(),
            preparationMode = preparationMode.text.toString()
        )

        view.findViewById<Button>(R.id.btn_save).setOnClickListener {
            val action = RegistrationFragmentDirections.actionRegistrationToList(
                recipe
            )
            findNavController().navigate(action)
        }
    }
}