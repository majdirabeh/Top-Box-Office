package fr.dev.majdi.boxotop.feature_movie_cards.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import fr.dev.majdi.boxotop.feature_movie_cards.domain.repository.MovieCardsRepository
import fr.dev.majdi.boxotop.feature_movie_cards.domain.use_case.MovieCardsUseCases
import fr.dev.majdi.boxotop.feature_movie_cards.domain.use_case.SearchMovieCardsUseCase

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@Module
@InstallIn(ViewModelComponent::class)
object MovieCardsDomainModule {

    @Provides
    @ViewModelScoped
    fun providesMovieCardsUseCases(movieCardsRepository: MovieCardsRepository): MovieCardsUseCases {
        return MovieCardsUseCases(
            getDefaultMovieCardsUseCase = SearchMovieCardsUseCase(movieCardsRepository),
            searchMovieUseCase = SearchMovieCardsUseCase(movieCardsRepository)
        )
    }

}