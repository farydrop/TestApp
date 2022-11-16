package com.example.testapp.domain.entity

data class ProductDetails(
    val CPU: String,
    val camera: String,
    val capacity: List<Capacity>,
    val color: List<Color>,
    val id: String,
    val images: List<Images>,
    val isFavorites: Boolean,
    val price: Int,
    val rating: Double,
    val sd: String,
    val ssd: String,
    val title: String
)

data class Images(
    val imgOne: String,
    val imgTwo: String
)

data class Color(
    val colorOne: String,
    val colorTwo: String
)

data class Capacity(
    val capacityOne: String,
    val capacityTwo: String
)
