package fr.dev.majdi.boxotop.core.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

/**
 * Created by Majdi RABEH on 29/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchCompose(
    modifier: Modifier = Modifier,
    searchTextFieldValue: String,
    onSearchTextFieldValueChange: (String) -> Unit,
    onSearchTextFieldClicked: () -> Unit,
    searchEnabled: Boolean = true,
    searchFieldPlaceHolder: Int,
    showKeyboardOnStart: Boolean = false
) {
    val showKeyboard by remember { mutableStateOf(true) }
    val focusRequester = FocusRequester()
    val keyboard = LocalSoftwareKeyboardController.current

    val searchModifier = if (!showKeyboardOnStart) {
        modifier
            .wrapContentSize()
            .padding(start = 4.dp, end = 4.dp)
            .clickable {
                onSearchTextFieldClicked()
            }
    } else {
        modifier
            .wrapContentSize()
            .padding(start = 4.dp, end = 4.dp)
            .focusRequester(focusRequester)
    }

    TextField(
        modifier = searchModifier,
        enabled = searchEnabled,
        value = searchTextFieldValue,
        onValueChange = onSearchTextFieldValueChange,
        shape = RoundedCornerShape(8.dp),
        placeholder = {
            Text(
                fontSize = 14.sp,
                text = stringResource(searchFieldPlaceHolder)
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onSecondary,
            placeholderColor = Color.DarkGray,
            backgroundColor = Color.LightGray,
            cursorColor = Color.Black,
            disabledLabelColor = MaterialTheme.colors.primary,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledTextColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.DarkGray
            )
        },
    )

    LaunchedEffect(focusRequester) {
        if (showKeyboard && showKeyboardOnStart) {
            focusRequester.requestFocus()
            delay(100)
            keyboard?.show()
        }
    }

}