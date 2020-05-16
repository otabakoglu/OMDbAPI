package com.otabakoglu.omdbapi.data.repository

import com.otabakoglu.omdbapi.data.model.FilmProperty
import com.otabakoglu.omdbapi.data.source.remote.OmdbApiService
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val omdbApiService: OmdbApiService): OmdbRepository {

    override fun getFilmByTitleAsync(title: String): Deferred<FilmProperty>  =
        omdbApiService.getFilmByTitleAsync(title = title)

}