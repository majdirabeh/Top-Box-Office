package fr.dev.majdi.boxotop.feature_movie_cards.domain.repository

import fr.dev.majdi.boxotop.core.util.Resource
import fr.dev.majdi.boxotop.feature_movie_cards.data.remote.dto.ApiResponseDto

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
interface MovieCardsRepository {
    /**
     * Searching for movie or series with title name
     */
    suspend fun searchMovie(
        title: String,
        type: String,
        page: String,
        plot: String,
        apiKey: String
    ): Resource<ApiResponseDto>

}