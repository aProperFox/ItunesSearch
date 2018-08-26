package com.aproperfox.itunessearch.api

import com.aproperfox.itunessearch.api.models.SearchResults
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface iTunesSearchApi {

  @GET("search")
  fun search(
      @Query("term") term: String,
      @Query("country") country: String = Locale.US.country,
      @Query("media") media: String? = null,
      @Query("entity") entity: String? = null,
      @Query("attribute") attribute: String? = null,
      @Query("limit") limit: Int? = null,
      @Query("lang") language: String? = Locale.US.language,
      @Query("version") version: Int? = null,
      @Query("explicit") explicit: String? = null
  ) : Single<SearchResults>

  @GET("lookup")
  fun lookupById(@Query("id") iTunesId: Int) : Single<SearchResults>

  @GET("lookup")
  fun lookupByArtistId(@Query("amgArtistId") vararg amgArtistId: Int) : Single<SearchResults>

  @GET("lookup")
  fun lookupByAlbumId(@Query("amgAlbumId") vararg amgAlbumId: Int) : Single<SearchResults>

  @GET("lookup")
  fun lookupByVideoId(@Query("amgVideoId") vararg amgVideoId: Int) : Single<SearchResults>

  @GET("lookup")
  fun lookupByUPC(@Query("upc") upc: Int) : Single<SearchResults>

  @GET("lookup")
  fun lookupByISBN(@Query("isbn") isbn: Int) : Single<SearchResults>

}