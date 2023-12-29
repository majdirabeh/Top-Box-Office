package fr.dev.majdi.boxotop.feature_movie_cards.data.remote.api

import fr.dev.majdi.boxotop.feature_movie_cards.data.remote.dto.ApiResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
interface MovieCardsApi {

    @GET("/")
    suspend fun searchMovie(
        @Query("s") title: String,
        @Query("type") type: String,
        @Query("page") page: String,
        @Query("plot") plot: String,
        @Query("apikey") apiKey: String
    ): Response<ApiResponseDto>

}