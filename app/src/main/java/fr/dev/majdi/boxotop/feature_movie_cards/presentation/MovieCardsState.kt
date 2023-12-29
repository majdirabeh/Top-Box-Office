package fr.dev.majdi.boxotop.feature_movie_cards.presentation

import fr.dev.majdi.boxotop.feature_movie_cards.domain.model.Search

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
data class MovieCardsState(
    val isLoading: Boolean = false,
    val search: List<Search>? = null
)