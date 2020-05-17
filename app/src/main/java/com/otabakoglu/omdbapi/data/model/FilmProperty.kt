package com.otabakoglu.omdbapi.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmProperty(
    @Json(name = "Title") val title: String?,
    @Json(name = "Year") val year: String?,
    @Json(name = "Poster") val poster: String?,
    @Json(name = "Genre") val genre: String?,
    @Json(name = "Actors") val actors: String?,
    @Json(name = "Plot") val plot: String?,
    @Json(name = "imdbRating") val imdbRating: String?,
    @Json(name = "Response") val response: String,
    @Json(name = "Error") val error: String?
) : Parcelable {
    fun isResponse() = response == "True"
}



// Example data for this model ⬇
/*
{
   "Title":"Blade",
   "Year":"1998",
   "Rated":"R",
   "Released":"21 Aug 1998",
   "Runtime":"120 min",
   "Genre":"Action, Horror, Sci-Fi",
   "Director":"Stephen Norrington",
   "Writer":"David S. Goyer",
   "Actors":"Wesley Snipes, Stephen Dorff, Kris Kristofferson, N'Bushe Wright",
   "Plot":"A half-vampire, half-mortal man becomes a protector of the mortal race, while slaying evil vampires.",
   "Language":"English, Russian, Serbian",
   "Country":"USA",
   "Awards":"5 wins & 10 nominations.",
   "Poster":"https://m.media-amazon.com/images/M/MV5BOTk2NDNjZWQtMGY0Mi00YTY2LWE5MzctMGRhZmNlYzljYTg5XkEyXkFqcGdeQXVyMTAyNjg4NjE0._V1_SX300.jpg",
   "Ratings":[
      {
         "Source":"Internet Movie Database",
         "Value":"7.1/10"
      },
      {
         "Source":"Rotten Tomatoes",
         "Value":"55%"
      },
      {
         "Source":"Metacritic",
         "Value":"45/100"
      }
   ],
   "Metascore":"45",
   "imdbRating":"7.1",
   "imdbVotes":"236,221",
   "imdbID":"tt0120611",
   "Type":"movie",
   "DVD":"22 Dec 1998",
   "BoxOffice":"N/A",
   "Production":"New Line Cinema",
   "Website":"N/A",
   "Response":"True"
}
 */