package fr.dev.majdi.boxotop.feature_movie_cards.data.remote.dto

import com.squareup.moshi.Json
import fr.dev.majdi.boxotop.feature_movie_cards.domain.model.ApiResponse

data class ApiResponseDto(
    @Json(name = "Response") val response: String,
    @Json(name = "Search") val search: List<SearchDto>,
    @Json(name = "totalResults") val totalResults: String
)

fun ApiResponseDto.toApiResponse(): ApiResponse {
    return ApiResponse(totalResults = this.totalResults,
        response = this.response,
        search = this.search.map { it.toSearch() }
    )
}