package fr.dev.majdi.boxotop.feature_splash.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    //We can add Use case here for getting Ui Mode or Language
) : ViewModel() {
    //To be implement if we need changing Ui Mode (Dark/Light) or getting language using by user...
}