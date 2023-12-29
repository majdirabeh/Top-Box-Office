package fr.dev.majdi.boxotop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.dev.majdi.boxotop.core.presentation.navigation.NavGraph
import fr.dev.majdi.boxotop.core.presentation.ui.theme.BoxotopTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxotopTheme {
                val navController = rememberNavController()
                NavGraph(navController)
            }
        }
    }

}