package fr.dev.majdi.boxotop.feature_splash.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import fr.dev.majdi.boxotop.R
import fr.dev.majdi.boxotop.feature_splash.util.Constants.Companion.SPLASH_SCREEN_DELAY
import kotlinx.coroutines.delay

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 * This is optional View
 */
@Composable
fun SplashScreen(
    //splashScreenViewModel: SplashScreenViewModel = hiltViewModel(),
    navigateToMovieCardsScreen: () -> Unit
) {

    val animationSpec = rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(resId = R.raw.splash)
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val composition by animationSpec
            LottieAnimation(
                modifier = Modifier.size(size = 140.dp),
                composition = composition,
                speed = 0.5f,
                iterations = LottieConstants.IterateForever // animate forever
            )
            // Navigate to the next screen when animation finishes
            LaunchedEffect(key1 = composition) {
                delay(SPLASH_SCREEN_DELAY)
                navigateToMovieCardsScreen.invoke()
            }
        }
    }

}