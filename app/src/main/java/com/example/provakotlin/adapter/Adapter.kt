package com.example.provakotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.provakotlin.R
import com.example.provakotlin.model.Recipe
import kotlinx.android.synthetic.main.res_layout.view.*

class Adapter (private val onClicked: () -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var items: List<Recipe>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ScheduleViewHolder(

            LayoutInflater.from(parent.context).inflate(R.layout.fragment_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ScheduleViewHolder -> {
                holder.bind(items[position], onClicked)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setDataSet(list: List<Recipe> ){
        this.items = list
    }

    class ScheduleViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {

        private val recipeTitle = itemView.textViewTitle
        private val recipeIngredients = itemView.textViewReceipeIngredients
        private val recipePrepareMode = itemView.textViewReceipePreparation

        fun bind(recipe: Recipe, onClicked: () -> Unit){

            recipeTitle.text = recipe.title
            recipeIngredients.text = recipe.ingredients
            recipePrepareMode.text = recipe.preparationMode

            itemView.setOnClickListener{
                onClicked()
            }
        }
    }
}
