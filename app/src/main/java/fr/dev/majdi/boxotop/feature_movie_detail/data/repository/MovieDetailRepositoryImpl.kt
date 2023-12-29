package fr.dev.majdi.boxotop.feature_movie_detail.data.repository

import fr.dev.majdi.boxotop.core.data.util.safeApiCallReturnResource
import fr.dev.majdi.boxotop.core.util.Resource
import fr.dev.majdi.boxotop.feature_movie_detail.data.datasources.MovieDetailRemoteDataSource
import fr.dev.majdi.boxotop.feature_movie_detail.data.remote.dto.MovieDetailDto
import fr.dev.majdi.boxotop.feature_movie_detail.domain.repository.MovieDetailRepository
import javax.inject.Inject

/**
 * Created by Majdi RABEH on 29/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
class MovieDetailRepositoryImpl @Inject constructor(
    private val movieDetailRemoteDataSource: MovieDetailRemoteDataSource
) : MovieDetailRepository {

    override suspend fun getMovieDetail(imdbID: String, apiKey: String): Resource<MovieDetailDto> {
        return safeApiCallReturnResource {
            movieDetailRemoteDataSource.getMovieDetailFromApi(imdbID = imdbID, apiKey = apiKey)
        }
    }
}