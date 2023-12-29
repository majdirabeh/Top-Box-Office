package fr.dev.majdi.boxotop.feature_movie_detail.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import fr.dev.majdi.boxotop.feature_movie_detail.data.datasources.MovieDetailRemoteDataSource
import fr.dev.majdi.boxotop.feature_movie_detail.data.datasources.MovieDetailRemoteResourceImp
import fr.dev.majdi.boxotop.feature_movie_detail.data.repository.MovieDetailRepositoryImpl
import fr.dev.majdi.boxotop.feature_movie_detail.domain.repository.MovieDetailRepository

/**
 * Created by Majdi RABEH on 29/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieDetailModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMovieCardsRemoteDataSource(
        movieDetailResourceImp: MovieDetailRemoteResourceImp
    ): MovieDetailRemoteDataSource

    @Binds
    @ViewModelScoped
    abstract fun bindMovieDetailRepository(
        movieDetailRepositoryImpl: MovieDetailRepositoryImpl
    ): MovieDetailRepository
}