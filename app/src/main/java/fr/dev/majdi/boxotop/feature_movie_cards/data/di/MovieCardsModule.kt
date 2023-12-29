package fr.dev.majdi.boxotop.feature_movie_cards.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import fr.dev.majdi.boxotop.feature_movie_cards.data.remote.datasources.MovieCardsRemoteDataSource
import fr.dev.majdi.boxotop.feature_movie_cards.data.remote.datasources.MovieCardsRemoteResourceImp
import fr.dev.majdi.boxotop.feature_movie_cards.data.repository.MovieCardsRepositoryImpl
import fr.dev.majdi.boxotop.feature_movie_cards.domain.repository.MovieCardsRepository

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieCardsModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMovieCardsRemoteDataSource(
        movieCardsRemoteResourceImp: MovieCardsRemoteResourceImp
    ): MovieCardsRemoteDataSource

    @Binds
    @ViewModelScoped
    abstract fun bindMovieCardsRepository(
        movieCardsRepositoryImpl: MovieCardsRepositoryImpl
    ): MovieCardsRepository

}