package fr.dev.majdi.boxotop.feature_movie_detail.domain.use_case

import fr.dev.majdi.boxotop.core.presentation.util.UiText
import fr.dev.majdi.boxotop.core.util.Resource
import fr.dev.majdi.boxotop.feature_movie_detail.data.remote.dto.toMovieDetail
import fr.dev.majdi.boxotop.feature_movie_detail.domain.model.MovieDetail
import fr.dev.majdi.boxotop.feature_movie_detail.domain.repository.MovieDetailRepository
import javax.inject.Inject

/**
 * Created by Majdi RABEH on 29/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
class GetMovieDetailUseCase @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
) {

    suspend operator fun invoke(
        imdbID: String,
        apiKey: String
    ): Resource<MovieDetail> {

        val resource =
            movieDetailRepository.getMovieDetail(
                imdbID = imdbID,
                apiKey = apiKey
            )

        return when (resource) {
            is Resource.Success -> {
                resource.data?.let {
                    val movieDetail = it.toMovieDetail()
                    Resource.Success(movieDetail)
                } ?: Resource.Error(uiText = UiText.somethingWentWrong())
            }

            is Resource.Error -> {
                Resource.Error(resource.uiText ?: UiText.somethingWentWrong())
            }
        }

    }

}