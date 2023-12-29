package fr.dev.majdi.boxotop.core.data.util

import retrofit2.Response
import timber.log.Timber

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
inline fun <reified R> tryApiCall(
    block: () -> Response<R>
): R {

    val result = try {
        val response = block()
        if (response.isSuccessful) {
            response
        } else {
            throw ServiceUnavailableException()
        }
    } catch (e: Exception) {
        throw ServiceUnavailableException()
    }

    when (result.code()) {
        in 200..299 -> Unit
        500 -> throw ServiceUnavailableException()
        in 400..499 -> throw ServiceUnavailableException()
        else -> throw ServiceUnavailableException()
    }

    return try {
        result.body() ?: throw Exception()
    } catch (e: Exception) {
        Timber.tag("API CALL Exception =>").e(e.message.toString())
        throw ServiceUnavailableException()
    }
}

class ServiceUnavailableException : Exception() {
    override val message: String
        get() = "Oops, something went wrong. Please check your internet connection and try again later."
}