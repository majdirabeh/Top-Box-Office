package fr.dev.majdi.boxotop.feature_movie_cards.domain.model

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
data class ApiResponse(
    val response: String,
    val search: List<Search>,
    val totalResults: String
)