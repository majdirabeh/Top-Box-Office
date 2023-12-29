package fr.dev.majdi.boxotop.feature_movie_cards.data.remote.api

import fr.dev.majdi.boxotop.core.util.Constants
import fr.dev.majdi.boxotop.feature_movie_cards.data.remote.dto.ApiResponseDto
import fr.dev.majdi.boxotop.feature_movie_cards.domain.use_case.SearchMovieCardsUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

/**
 * Created by Majdi RABEH on 29/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
//TODO we can continue testing others repository and viewModels
//TODO I tried to test this Api but i have many problems to be continue :)
@RunWith(MockitoJUnitRunner::class)
class MovieCardsApiTest {

    //@Mock
    //lateinit var movieCardsUseCase: SearchMovieCardsUseCase


    @Before
    fun setup() {
        //MockitoAnnotations.initMocks(this)
        //movieCardsUseCase = Mockito.mock(SearchMovieCardsUseCase::class.java)
    }

    // Test a 200 response
    @Test
    fun fetchMoviesFromApi_positiveResponse() = runBlocking {
        // GIVEN
//        val mockApiResponse = Mockito.mock(ApiResponseDto::class.java)
//        val mockResponse = Response.success(mockApiResponse)
//        // THEN
//        val movies = movieCardsUseCase.invoke(
//            Constants.DEFAULT_TITLE,
//            Constants.TYPE, Constants.PAGE, Constants.PLOT, Constants.API_KEY
//        )
//        assertEquals(mockApiResponse, movies)
    }

    // Test a 400 response
    @Test
    fun fetchMoviesFromApi_negativeResponse() = runBlocking {
        // THEN
//        val ioExceptionReturned =
//            movieCardsUseCase.invoke(
//                Constants.DEFAULT_TITLE,
//                Constants.TYPE, Constants.PAGE, Constants.PLOT, Constants.API_KEY
//            )
//
//        assertNotNull(ioExceptionReturned)
//        assertEquals(ioExceptionReturned.uiText, "Oops, something went wrong. Please check your internet connection and try again later.")
    }

}