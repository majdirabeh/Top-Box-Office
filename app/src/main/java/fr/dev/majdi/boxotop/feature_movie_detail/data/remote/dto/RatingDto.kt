package fr.dev.majdi.boxotop.feature_movie_detail.data.remote.dto

import com.squareup.moshi.Json

data class RatingDto(
    @Json(name = "Source") val source: String,
    @Json(name = "Value") val value: String
)