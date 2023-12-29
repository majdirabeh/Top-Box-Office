package fr.dev.majdi.boxotop.feature_movie_detail.data.datasources

import fr.dev.majdi.boxotop.core.data.util.tryApiCall
import fr.dev.majdi.boxotop.feature_movie_detail.data.remote.api.MovieDetailApi
import fr.dev.majdi.boxotop.feature_movie_detail.data.remote.dto.MovieDetailDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Majdi RABEH on 29/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
class MovieDetailRemoteResourceImp @Inject constructor(
    private val movieDetailApi: MovieDetailApi
) : MovieDetailRemoteDataSource {

    override suspend fun getMovieDetailFromApi(imdbID: String, apiKey: String): MovieDetailDto {
        return withContext(Dispatchers.IO) {
            tryApiCall { movieDetailApi.getMovieDetail(id = imdbID, apiKey = apiKey) }
        }

    }
}