package fr.dev.majdi.boxotop.feature_movie_detail.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import fr.dev.majdi.boxotop.R
import fr.dev.majdi.boxotop.core.presentation.components.ComposableLifecycle
import fr.dev.majdi.boxotop.core.presentation.components.RatingBar
import fr.dev.majdi.boxotop.core.util.Constants.Companion.API_KEY

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel(),
    id: String,
    popBackStack: () -> Unit
) {


    ComposableLifecycle { _, event ->
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                id.let {
                    movieDetailViewModel.getMovieDetail(imdbID = id, apikey = API_KEY)
                }
            }

            Lifecycle.Event.ON_START -> {

            }

            Lifecycle.Event.ON_RESUME -> {

            }

            Lifecycle.Event.ON_PAUSE -> {

            }

            Lifecycle.Event.ON_STOP -> {

            }

            Lifecycle.Event.ON_DESTROY -> {

            }

            else -> {

            }
        }
    }

    val uiState: MovieDetailState by movieDetailViewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.appbar_title_details))
                },
                navigationIcon = {
                    IconButton(onClick = {
                        popBackStack.invoke()
                    }) {
                        Icon(Icons.Filled.ArrowBack, "")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 12.dp
            )
        }, content = { paddingValues ->
            if (uiState.isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .wrapContentSize(Alignment.Center)
                )
            } else {
                if (uiState.movieDetail == null) {
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
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(4.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start,
                            text = uiState.movieDetail?.title.toString(),
                            color = Color.Black,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            fontSize = 14.sp,
                            textAlign = TextAlign.Start,
                            text = uiState.movieDetail?.awards.toString(),
                            color = Color.Black,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            modifier = Modifier.wrapContentSize(),
                            horizontalArrangement = Arrangement.Start
                        ) {

                            Image(
                                painter = rememberAsyncImagePainter(
                                    model = uiState.movieDetail?.poster,
                                    contentScale = ContentScale.Crop
                                ),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(200.dp)
                                    .padding(4.dp)
                                    .wrapContentSize()
                                    .clip(shape = RoundedCornerShape(8.dp))
                            )

                            Column {

                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(4.dp),
                                    fontSize = 14.sp,
                                    textAlign = TextAlign.Start,
                                    text = stringResource(id = R.string.movie_detail_release_date) + " " + uiState.movieDetail?.released.toString(),
                                    color = Color.Black,
                                    style = MaterialTheme.typography.body1,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(4.dp),
                                    fontSize = 14.sp,
                                    textAlign = TextAlign.Start,
                                    text = stringResource(id = R.string.movie_detail_actors) + " " + uiState.movieDetail?.actors.toString(),
                                    color = Color.Black,
                                    style = MaterialTheme.typography.body1,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(4.dp),
                                    fontSize = 14.sp,
                                    textAlign = TextAlign.Start,
                                    text = stringResource(id = R.string.movie_detail_genre) + " " + uiState.movieDetail?.genre.toString(),
                                    color = Color.Black,
                                    style = MaterialTheme.typography.body1,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(4.dp),
                                    fontSize = 14.sp,
                                    textAlign = TextAlign.Start,
                                    text = stringResource(id = R.string.movie_detail_year) + " " + uiState.movieDetail?.year.toString(),
                                    color = Color.Black,
                                    style = MaterialTheme.typography.body1,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(4.dp),
                                    fontSize = 14.sp,
                                    textAlign = TextAlign.Start,
                                    text = stringResource(id = R.string.movie_detail_rating),
                                    color = Color.Black,
                                    style = MaterialTheme.typography.body1,
                                    fontWeight = FontWeight.Bold
                                )
                                uiState.movieDetail?.imdbRating?.let {
                                    if (it.isNotBlank()){
                                        RatingBar(
                                            currentRating = it.toFloat().toInt(),
                                        )
                                    }
                                }

                            }

                        }
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            fontSize = 14.sp,
                            textAlign = TextAlign.Start,
                            text = stringResource(id = R.string.movie_detail_description),
                            color = Color.Black,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            fontSize = 14.sp,
                            textAlign = TextAlign.Start,
                            text = uiState.movieDetail?.plot.toString(),
                            color = Color.Black,
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }

            }
        })

}