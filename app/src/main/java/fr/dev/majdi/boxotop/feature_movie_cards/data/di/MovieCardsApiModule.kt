package fr.dev.majdi.boxotop.feature_movie_cards.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import fr.dev.majdi.boxotop.feature_movie_cards.data.remote.api.MovieCardsApi
import retrofit2.Retrofit

/**
 * Created by Majdi RABEH on 28/12/2023.
 * Email m.rabeh.majdi@gmail.com
 */
@Module
@InstallIn(ViewModelComponent::class)
object MovieCardsApiModule {

    @Provides
    @ViewModelScoped
    fun provideMovieCardsApi(retrofit: Retrofit): MovieCardsApi {
        return retrofit.create(MovieCardsApi::class.java)
    }

}