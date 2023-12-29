package fr.dev.majdi.boxotop.feature_movie_detail.domain.repository

import fr.dev.majdi.boxotop.core.util.Resource
import fr.dev.majdi.boxotop.feature_movie_detail.data.remote.dto.MovieDetailDto

/**
 * Created by Majdi RABEH on 29/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
interface MovieDetailRepository {

    /**
     * Getting Movie or Series Detail
     */
    suspend fun getMovieDetail(
        imdbID: String,
        apiKey: String
    ): Resource<MovieDetailDto>
}