package fr.dev.majdi.boxotop.feature_movie_cards.data.remote.dto

import com.squareup.moshi.Json
import fr.dev.majdi.boxotop.feature_movie_cards.domain.model.Search

data class SearchDto(
    @Json(name = "Poster") val poster: String,
    @Json(name = "Title") val title: String,
    @Json(name = "Type") val type: String,
    @Json(name = "Year") val year: String,
    @Json(name = "imdbID") val imdbID: String
)

fun SearchDto.toSearch(): Search {
    return Search(
        poster = this.poster,
        title = this.title,
        type = this.type,
        year = this.year,
        imdbID = this.imdbID
    )
}