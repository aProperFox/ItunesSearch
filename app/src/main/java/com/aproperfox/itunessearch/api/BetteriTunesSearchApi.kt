package com.aproperfox.itunessearch.api

import android.support.annotation.IntRange
import com.aproperfox.itunessearch.api.models.*
import io.reactivex.Single
import java.util.*

interface BetteriTunesSearchApi {

  companion object {
    private val DEFAULT_LOCALE = Locale.US
    private const val DEFAULT_VERSION = 2
  }

  fun search(
      term: String,
      locale: Locale = DEFAULT_LOCALE,
      media: MediaType? = MediaType.All,
      entity: Entity? = null,
      attribute: Attribute? = null,
      @IntRange(from = 0, to = 250) limit: Int? = null,
      version: Int? = DEFAULT_VERSION,
      explicit: Boolean? = false
  ) : Single<SearchResponse>

  fun lookupByArtistId(amgArtistId: Int) : Single<SearchResponse>
  fun lookupByAlbumId(amgAlbumId: Int) : Single<SearchResponse>
  fun lookupByVideoId(amgVideoId: Int) : Single<SearchResponse>
  fun lookupByiTunesId(iTunesId: Int) : Single<SearchResponse>
  fun lookupByUPC(upc: Int) : Single<SearchResponse>
  fun lookupByISBN(isbn: Int) : Single<SearchResponse>

}