package fr.dev.majdi.boxotop.feature_movie_detail.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import fr.dev.majdi.boxotop.feature_movie_cards.domain.repository.MovieCardsRepository
import fr.dev.majdi.boxotop.feature_movie_cards.domain.use_case.MovieCardsUseCases
import fr.dev.majdi.boxotop.feature_movie_cards.domain.use_case.SearchMovieCardsUseCase
import fr.dev.majdi.boxotop.feature_movie_detail.domain.repository.MovieDetailRepository
import fr.dev.majdi.boxotop.feature_movie_detail.domain.use_case.GetMovieDetailUseCase
import fr.dev.majdi.boxotop.feature_movie_detail.domain.use_case.MovieDetailUseCases

/**
 * Created by Majdi RABEH on 29/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@Module
@InstallIn(ViewModelComponent::class)
object MovieDetailDomainModule {

    @Provides
    @ViewModelScoped
    fun providesMovieDetailUseCases(movieDetailRepository: MovieDetailRepository): MovieDetailUseCases {
        return MovieDetailUseCases(
            getMovieDetailUseCase = GetMovieDetailUseCase(movieDetailRepository)
        )
    }

}