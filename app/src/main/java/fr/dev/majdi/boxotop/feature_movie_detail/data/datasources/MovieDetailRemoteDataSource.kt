package fr.dev.majdi.boxotop.feature_movie_detail.data.datasources

import fr.dev.majdi.boxotop.feature_movie_detail.data.remote.dto.MovieDetailDto

/**
 * Created by Majdi RABEH on 29/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
interface MovieDetailRemoteDataSource {

    /**
     * Getting data from api
     */
    suspend fun getMovieDetailFromApi(
        imdbID: String,
        apiKey: String
    ): MovieDetailDto
}