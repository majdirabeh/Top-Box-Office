package fr.dev.majdi.boxotop.feature_movie_cards.domain.model

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
data class Search(
    val poster: String,
    val title: String,
    val type: String,
    val year: String,
    val imdbID: String
)