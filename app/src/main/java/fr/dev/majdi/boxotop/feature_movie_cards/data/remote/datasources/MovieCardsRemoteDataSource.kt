package fr.dev.majdi.boxotop.feature_movie_cards.data.remote.datasources

import fr.dev.majdi.boxotop.feature_movie_cards.data.remote.dto.ApiResponseDto

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
interface MovieCardsRemoteDataSource {

    /**
     * Search Movie from Api
     * We can add others sources like from db
     */
    suspend fun searchMovieFromApi(
        title: String,
        type: String,
        page: String,
        plot: String,
        apiKey: String
    ): ApiResponseDto
}