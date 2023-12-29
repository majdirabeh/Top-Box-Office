package fr.dev.majdi.boxotop.feature_movie_cards.presentation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import fr.dev.majdi.boxotop.R
import fr.dev.majdi.boxotop.core.presentation.components.SearchCompose
import fr.dev.majdi.boxotop.core.util.Constants
import fr.dev.majdi.boxotop.feature_movie_cards.domain.model.Search

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@Composable
fun MovieCardsScreen(
    movieCardsViewModel: MovieCardsViewModel = hiltViewModel(),
    navigateToMovieDetailScreen: (String) -> Unit
) {
    val activity = LocalContext.current as Activity

    val uiState: MovieCardsState by movieCardsViewModel.state.collectAsStateWithLifecycle()

    val searchTextState by movieCardsViewModel.searchFieldTextState


    Column(
        modifier = Modifier
            .padding(5.dp)
            .wrapContentSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .wrapContentSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(8.dp),
                painter = painterResource(id = R.drawable.tv),
                contentDescription = null
            )

            SearchCompose(
                searchTextFieldValue = searchTextState,
                onSearchTextFieldValueChange = {
                    movieCardsViewModel.updateSearchTextState(it)
                },
                onSearchTextFieldClicked = {

                },
                searchFieldPlaceHolder = R.string.search_hint,
                searchEnabled = true,
                showKeyboardOnStart = false
            )

            Image(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clickable {
                        movieCardsViewModel.searchInputFlow.value = ""
                        movieCardsViewModel.getMovies(
                            Constants.DEFAULT_TITLE, Constants.TYPE,
                            Constants.PAGE, Constants.PLOT, Constants.API_KEY
                        )
                    }
                    .padding(8.dp),
                painter = painterResource(id = R.drawable.refresh),
                contentDescription = null
            )

        }

        if (uiState.isLoading) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .wrapContentSize(Alignment.Center)
            )
        } else {
            if (uiState.search.isNullOrEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Oops, something went wrong!",
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            } else {
                LazyColumn {
                    items(uiState.search.orEmpty()) { movie ->
                        MovieCard(movie = movie) {
                            navigateToMovieDetailScreen(it.imdbID)
                        }
                    }
                }
            }

        }

    }

    BackHandler {
        //I add this just for not going to splash screen when back press called
        activity.finish()
    }
}

@Composable
fun MovieCard(movie: Search, onMovieClick: (Search) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            Color.White
        ),
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onMovieClick(movie)
            }
    ) {

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = movie.poster,
                    contentScale = ContentScale.Crop
                ),
                contentDescription = "Image",
                modifier = Modifier
                    .width(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .height(150.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(8.dp),
                    text = movie.title,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    color = Color.Black
                )
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(8.dp),
                    text = stringResource(id = R.string.movie_cards_type) + " ${movie.type}",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    color = Color.Black
                )
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(8.dp),
                    text = stringResource(id = R.string.movie_cards_year) + " ${movie.year}",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Start,
                    color = Color.Black
                )
            }

        }
    }
}