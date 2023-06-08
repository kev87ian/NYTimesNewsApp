package com.kev.nytimes.data.repository

import com.kev.nytimes.core.Resource
import com.kev.nytimes.data.NewsApiService
import com.kev.nytimes.domain.model.mostviewedarticles.MostViewedResult
import com.kev.nytimes.domain.model.searcharticles.Doc
import com.kev.nytimes.domain.model.topstories.Result
import com.kev.nytimes.domain.repository.NewsRepository
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber

class NewsRepositoryImpl constructor(
    private val apiService: NewsApiService
) : NewsRepository {
    override suspend fun getTopStories(): Flow<Resource<List<Result>>> = flow {
        emit(Resource.Loading())
        try {

            val networkResponse = apiService.getTopStories().resultDTOS
            emit(Resource.Success(networkResponse.map { it.toDomainResult() }))
        } catch (e: Exception) {
            e.printStackTrace()

            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
        } catch (e: IOException) {
            e.printStackTrace()

            emit(Resource.Error("Please ensure you have an active internet connection."))
        } catch (e: HttpException) {
            e.printStackTrace()

            if (e.code() == 500) {
                emit(Resource.Error("We're unable to reach servers. Please retry"))
            }
            if (e.code() == 404) {
                emit(Resource.Error("Resources not found"))
            } else {
                emit(Resource.Error(e.localizedMessage ?: "An uncaught exception occured"))
            }
        }
    }

    override suspend fun searchArticles(query: String): Flow<Resource<List<Doc>>> = flow {
        emit(Resource.Loading())
        try {
            val apiResponse = apiService.searchArticles(query).searchResponseDTO.docDTOS
            emit(Resource.Success(apiResponse.map { it.toDomainDoc() }))
        }catch (e: Exception) {
           e.printStackTrace()
            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error("Please ensure you have an active internet connection."))
        } catch (e: HttpException) {
            e.printStackTrace()
            if (e.code() == 500) {
                emit(Resource.Error("We're unable to reach servers. Please retry"))
            }
            if (e.code() == 404) {
                emit(Resource.Error("Resources not found"))
            } else {
                emit(Resource.Error(e.localizedMessage ?: "An uncaught exception occured"))
            }
        }
    }

    override suspend fun getMostViewedArticles(): Flow<Resource<List<MostViewedResult>>> = flow {
        emit(Resource.Loading())
        try {
            val apiResponse = apiService.getMostViewedArticles().mostViewedResultDTOS.map { it.toDomainMostViewedResult() }
            emit(Resource.Success(apiResponse))
        }catch (e: Exception) {
            Timber.e(e.localizedMessage)
            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
        } catch (e: IOException) {
            Timber.e("IoException")
            emit(Resource.Error("Please ensure you have an active internet connection."))
        } catch (e: HttpException) {
            Timber.e("HTTP Exception")
            if (e.code() == 500) {
                emit(Resource.Error("We're unable to reach servers. Please retry"))
            }
            if (e.code() == 404) {
                emit(Resource.Error("Resources not found"))
            } else {
                emit(Resource.Error(e.localizedMessage ?: "An uncaught exception occured"))
            }
        }
    }
}
