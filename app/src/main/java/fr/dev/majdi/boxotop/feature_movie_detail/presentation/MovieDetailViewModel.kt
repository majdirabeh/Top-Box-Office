package fr.dev.majdi.boxotop.feature_movie_detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.dev.majdi.boxotop.core.util.Resource
import fr.dev.majdi.boxotop.feature_movie_detail.domain.use_case.GetMovieDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {

    private val mutableState = MutableStateFlow(MovieDetailState())
    val state = mutableState.asStateFlow()

    fun getMovieDetail(
        imdbID: String, apikey: String
    ) {
        mutableState.update { it.copy(isLoading = true) }
        viewModelScope.launch() {
            getMovieDetailUseCase.invoke(
                imdbID = imdbID, apiKey = apikey
            ).let { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.let {
                            mutableState.value =
                                MovieDetailState(isLoading = false, movieDetail = it)
                        }
                        mutableState.update { it.copy(isLoading = false) }
                    }

                    is Resource.Error -> {
                        mutableState.value =
                            MovieDetailState(isLoading = false, movieDetail = null)
                        mutableState.update { it.copy(isLoading = false) }
                    }
                }
            }
        }
    }

}