package fr.dev.majdi.boxotop.core.data.util

import fr.dev.majdi.boxotop.core.presentation.util.UiText
import fr.dev.majdi.boxotop.core.util.Resource
import timber.log.Timber

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
suspend inline fun <T : Any> safeApiCallReturnResource(
    crossinline apiCall: suspend () -> T,
): Resource<T> {
    return try {
        val response = apiCall.invoke()
        Resource.Success(response)
    } catch (e: Exception) {
        Timber.tag("API CALL Exception =>").e(e.message.toString())
        Resource.Error(UiText.somethingWentWrong())
    }
}