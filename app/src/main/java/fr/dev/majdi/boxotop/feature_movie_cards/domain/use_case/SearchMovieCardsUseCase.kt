package fr.dev.majdi.boxotop.feature_movie_cards.domain.use_case

import fr.dev.majdi.boxotop.core.presentation.util.UiText
import fr.dev.majdi.boxotop.core.util.Resource
import fr.dev.majdi.boxotop.feature_movie_cards.data.remote.dto.toApiResponse
import fr.dev.majdi.boxotop.feature_movie_cards.domain.model.ApiResponse
import fr.dev.majdi.boxotop.feature_movie_cards.domain.repository.MovieCardsRepository
import javax.inject.Inject

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
class SearchMovieCardsUseCase @Inject constructor(
    private val movieCardsRepository: MovieCardsRepository
) {
    suspend operator fun invoke(
        title: String,
        type: String,
        page: String,
        plot: String,
        apiKey: String
    ): Resource<ApiResponse> {

        val resource =
            movieCardsRepository.searchMovie(
                title = title,
                type = type,
                page = page,
                plot = plot,
                apiKey = apiKey
            )

        return when (resource) {
            is Resource.Success -> {
                resource.data?.let {
                    val apiResponse = it.toApiResponse()
                    Resource.Success(apiResponse)
                } ?: Resource.Error(uiText = UiText.somethingWentWrong())
            }

            is Resource.Error -> {
                Resource.Error(resource.uiText ?: UiText.somethingWentWrong())
            }
        }

    }
}