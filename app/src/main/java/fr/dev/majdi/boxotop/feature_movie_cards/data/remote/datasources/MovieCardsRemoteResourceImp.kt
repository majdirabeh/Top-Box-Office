package fr.dev.majdi.boxotop.feature_movie_cards.data.remote.datasources

import fr.dev.majdi.boxotop.core.data.util.tryApiCall
import fr.dev.majdi.boxotop.feature_movie_cards.data.remote.api.MovieCardsApi
import fr.dev.majdi.boxotop.feature_movie_cards.data.remote.dto.ApiResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
class MovieCardsRemoteResourceImp @Inject constructor(
    private val movieCardsApi: MovieCardsApi
    //We can get movies from local db here
) : MovieCardsRemoteDataSource {

    /**
     * Getting data from api
     */
    override suspend fun searchMovieFromApi(
        title: String,
        type: String,
        page: String,
        plot: String,
        apiKey: String
    ): ApiResponseDto {
        return withContext(Dispatchers.IO) {
            tryApiCall { movieCardsApi.searchMovie(title, type, page, plot, apiKey) }
        }
    }

}