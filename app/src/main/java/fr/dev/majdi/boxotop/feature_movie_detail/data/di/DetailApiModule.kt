package fr.dev.majdi.boxotop.feature_movie_detail.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import fr.dev.majdi.boxotop.feature_movie_detail.data.remote.api.MovieDetailApi
import retrofit2.Retrofit

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@Module
@InstallIn(ViewModelComponent::class)
object DetailApiModule {

    @Provides
    @ViewModelScoped
    fun provideMovieDetailApi(retrofit: Retrofit): MovieDetailApi {
        return retrofit.create(MovieDetailApi::class.java)
    }

}