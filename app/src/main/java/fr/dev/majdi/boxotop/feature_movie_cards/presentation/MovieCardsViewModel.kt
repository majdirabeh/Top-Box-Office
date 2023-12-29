package fr.dev.majdi.boxotop.feature_movie_cards.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.dev.majdi.boxotop.core.util.Constants.Companion.API_KEY
import fr.dev.majdi.boxotop.core.util.Constants.Companion.DEFAULT_TITLE
import fr.dev.majdi.boxotop.core.util.Constants.Companion.PAGE
import fr.dev.majdi.boxotop.core.util.Constants.Companion.PLOT
import fr.dev.majdi.boxotop.core.util.Constants.Companion.TYPE
import fr.dev.majdi.boxotop.core.util.Resource
import fr.dev.majdi.boxotop.feature_movie_cards.domain.use_case.MovieCardsUseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@OptIn(FlowPreview::class)
@HiltViewModel
class MovieCardsViewModel @Inject constructor(private val movieCardsUseCases: MovieCardsUseCases) :
    ViewModel() {

    private val mutableState = MutableStateFlow(MovieCardsState())
    val state = mutableState.asStateFlow()

    private val _searchFieldTextState: MutableState<String> = mutableStateOf("")
    val searchFieldTextState: State<String> = _searchFieldTextState

    val searchInputFlow = MutableStateFlow("")

    init {
        getMovies(DEFAULT_TITLE, TYPE, PAGE, PLOT, API_KEY)

        searchInputFlow
            .debounce(500) // call api after user tapping with 5 milliseconds
            .filterNot { userInput ->
                userInput.isEmpty()
            } // unnecessary network call when text is empty.
            .distinctUntilChanged() // to avoid duplicate network calls
            .flowOn(Dispatchers.IO)
            .onEach { userInput ->
                getMovies(userInput, TYPE, PAGE, PLOT, API_KEY)
            }
            .launchIn(viewModelScope)
    }

    fun getMovies(
        title: String, type: String, page: String, plot: String, apikey: String
    ) {
        mutableState.update { it.copy(isLoading = true) }
        viewModelScope.launch() {
            movieCardsUseCases.getDefaultMovieCardsUseCase.invoke(
                title = title, type = type, page = page, plot = plot, apiKey = apikey
            ).let { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data?.search?.let {
                            mutableState.value = MovieCardsState(isLoading = false, search = it)
                        }
                        mutableState.update { it.copy(isLoading = false) }
                    }

                    is Resource.Error -> {
                        mutableState.value =
                            MovieCardsState(isLoading = false, search = emptyList())
                        mutableState.update { it.copy(isLoading = false) }
                    }
                }
            }
        }
    }

    fun updateSearchTextState(newValue: String) {
        //update search field with the new text as the user types
        _searchFieldTextState.value = newValue
        searchInputFlow.value = newValue
    }


}