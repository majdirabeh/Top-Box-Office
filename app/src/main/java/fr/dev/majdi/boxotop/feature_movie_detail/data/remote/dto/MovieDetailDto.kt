package fr.dev.majdi.boxotop.feature_movie_detail.data.remote.dto

import com.squareup.moshi.Json
import fr.dev.majdi.boxotop.feature_movie_detail.domain.model.MovieDetail

data class MovieDetailDto(
    @Json(name = "Actors") val actors: String?,
    @Json(name = "Awards") val awards: String?,
    @Json(name = "Country") val country: String?,
    @Json(name = "Director") val director: String?,
    @Json(name = "Genre") val genre: String?,
    @Json(name = "Language") val language: String?,
    @Json(name = "Metascore") val metaScore: String?,
    @Json(name = "Plot") val plot: String?,
    @Json(name = "Poster") val poster: String?,
    @Json(name = "Rated") val rated: String?,
    @Json(name = "Ratings") val ratings: List<RatingDto>?,
    @Json(name = "Released") val released: String?,
    @Json(name = "Response") val response: String?,
    @Json(name = "Runtime") val runtime: String?,
    @Json(name = "Title") val title: String?,
    @Json(name = "Type") val type: String?,
    @Json(name = "Writer") val writer: String?,
    @Json(name = "Year") val year: String?,
    @Json(name = "imdbID") val imdbID: String?,
    @Json(name = "imdbRating") val imdbRating: String?,
    @Json(name = "imdbVotes") val imdbVotes: String?,
    @Json(name = "DVD") val dvd: String?,
    @Json(name = "BoxOffice") val boxOffice: String?,
    @Json(name = "Production") val production: String?,
    @Json(name = "Website") val website: String?,
    @Json(name = "totalSeasons") val totalSeasons: String?
)

fun MovieDetailDto.toMovieDetail(): MovieDetail {
    return MovieDetail(
        actors = this.actors,
        awards = this.awards,
        country = this.country,
        director = this.director,
        genre = this.genre,
        language = this.language,
        metaScore = this.metaScore,
        plot = this.plot,
        poster = this.poster,
        rated = this.rated,
        released = this.released,
        response = this.response,
        runtime = this.runtime,
        title = this.title,
        type = this.type,
        writer = this.writer,
        year = this.year,
        imdbID = this.imdbID,
        imdbRating = this.imdbRating,
        imdbVotes = this.imdbVotes,
        boxOffice = this.boxOffice,
        dvd = this.dvd,
        production = this.production,
        website = this.website,
        totalSeasons = this.totalSeasons
    )
}