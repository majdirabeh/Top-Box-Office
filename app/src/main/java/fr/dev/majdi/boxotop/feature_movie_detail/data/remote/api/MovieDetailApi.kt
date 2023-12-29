package fr.dev.majdi.boxotop.feature_movie_detail.data.remote.api

import fr.dev.majdi.boxotop.core.util.Resource
import fr.dev.majdi.boxotop.feature_movie_detail.data.remote.dto.MovieDetailDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
interface MovieDetailApi {

    @GET("/")
    suspend fun getMovieDetail(
        @Query("i") id: String,
        @Query("apikey") apiKey: String
    ): Response<MovieDetailDto>

}