package com.aproperfox.itunessearch.api

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
  )

  @GET("lookup")
  fun lookupById(@Query("id") iTunesId: Int)

  @GET("lookup")
  fun lookupByArtistId(@Query("amgArtistId") vararg amgArtistId: Int)

  @GET("lookup")
  fun lookupByAlbumId(@Query("amgAlbumId") vararg amgAlbumId: Int)

  @GET("lookup")
  fun lookupByVideoId(@Query("amgVideoId") vararg amgVideoId: Int)

  @GET("lookup")
  fun lookupByUPC(@Query("upc") upc: Int)

  @GET("lookup")
  fun lookupByISBN(@Query("isbn") isbn: Int)

}