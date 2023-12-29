package fr.dev.majdi.boxotop.core.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Created by Majdi RABEH on 29/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@Composable
fun RatingBar(
    maxRating: Int = 10, currentRating: Int, starsColor: Color = Color.Yellow
) {
    Row(modifier = Modifier
        .wrapContentSize()) {
        for (i in 1..maxRating) {
            Icon(
                imageVector = if (i <= currentRating) Icons.Filled.Star
                else Icons.Filled.StarOutline,
                contentDescription = null,
                tint = if (i <= currentRating) starsColor
                else Color.Unspecified,
                modifier = Modifier.padding(4.dp).size(15.dp)
            )
        }
    }
}