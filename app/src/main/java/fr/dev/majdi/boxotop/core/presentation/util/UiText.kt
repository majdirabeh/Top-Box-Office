package fr.dev.majdi.boxotop.core.presentation.util

import android.content.Context
import androidx.annotation.StringRes
import fr.dev.majdi.boxotop.R

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
sealed class UiText {
    data class DynamicText(val value: String) : UiText()
    data class StringResource(@StringRes val id: Int) : UiText()

    companion object {
        fun unknownError(): UiText {
            return StringResource(R.string.unknown_error)
        }

        fun somethingWentWrong(): UiText {
            return StringResource(R.string.something_went_wrong)
        }
    }
}

fun UiText.asString(context: Context): String {
    return when (this) {
        is UiText.DynamicText -> this.value
        is UiText.StringResource -> context.getString(this.id)
    }
}