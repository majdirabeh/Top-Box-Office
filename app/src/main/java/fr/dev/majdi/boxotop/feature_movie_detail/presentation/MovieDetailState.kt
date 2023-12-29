package fr.dev.majdi.boxotop.feature_movie_detail.presentation

import fr.dev.majdi.boxotop.feature_movie_detail.domain.model.MovieDetail

/**
 * Created by Majdi RABEH on 29/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
data class MovieDetailState(
    var isLoading: Boolean = false,
    var movieDetail: MovieDetail? = null
)