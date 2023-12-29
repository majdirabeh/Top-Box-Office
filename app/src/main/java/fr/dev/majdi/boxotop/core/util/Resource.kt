package fr.dev.majdi.boxotop.core.util

import fr.dev.majdi.boxotop.core.presentation.util.UiText

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
sealed class Resource<T>(val data: T? = null, val uiText: UiText? = null) {
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(uiText: UiText, data: T? = null) : Resource<T>(data = data, uiText = uiText)
}