package fr.dev.majdi.boxotop.feature_movie_cards.data.repository

import fr.dev.majdi.boxotop.core.data.util.safeApiCallReturnResource
import fr.dev.majdi.boxotop.core.util.Resource
import fr.dev.majdi.boxotop.feature_movie_cards.data.remote.datasources.MovieCardsRemoteDataSource
import fr.dev.majdi.boxotop.feature_movie_cards.data.remote.dto.ApiResponseDto
import fr.dev.majdi.boxotop.feature_movie_cards.domain.repository.MovieCardsRepository
import javax.inject.Inject

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
class MovieCardsRepositoryImpl @Inject constructor(
    private val movieCardsRemoteDataSource: MovieCardsRemoteDataSource
) : MovieCardsRepository {
    override suspend fun searchMovie(
        title: String,
        type: String,
        page: String,
        plot: String,
        apiKey: String
    ): Resource<ApiResponseDto> {
        return safeApiCallReturnResource {
            movieCardsRemoteDataSource.searchMovieFromApi(title, type, page, plot, apiKey)
        }
    }


}