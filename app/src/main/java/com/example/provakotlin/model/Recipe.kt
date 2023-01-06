package com.example.provakotlin.model

import java.io.Serializable

data class Recipe (
        var title: String,
        var ingredients: String,
        var preparationMode: String
): Serializable