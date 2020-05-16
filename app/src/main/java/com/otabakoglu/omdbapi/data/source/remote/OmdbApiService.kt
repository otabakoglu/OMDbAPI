package com.otabakoglu.omdbapi.data.source.remote

import com.otabakoglu.omdbapi.data.model.FilmProperty
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbApiService {

    @GET(".")
    fun getFilmByTitleAsync(@Query("apikey") apiKey: String = "6a41a11", @Query("t") title: String):
            Deferred<FilmProperty>
}