package com.kev.nytimes.di

import com.google.gson.Gson
import com.kev.nytimes.core.Constants
import com.kev.nytimes.data.NewsApiService
import com.kev.nytimes.data.repository.NewsRepositoryImpl
import com.kev.nytimes.domain.repository.NewsRepository
import com.kev.nytimes.domain.usecases.GetTopArticlesUseCase
import com.kev.nytimes.domain.usecases.SearchArticlesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): NewsApiService{
        return retrofit.create(NewsApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesRepository(apiService: NewsApiService): NewsRepository{
        return NewsRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun providesTopStoriesUseCase(repository: NewsRepository): GetTopArticlesUseCase{
        return GetTopArticlesUseCase(repository)
    }

    @Singleton
    @Provides
    fun providesSearchArticlesUseCase(repository: NewsRepository): SearchArticlesUseCase{
        return SearchArticlesUseCase(repository)
    }
}