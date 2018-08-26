package com.aproperfox.itunessearch.api

import android.support.annotation.IntRange
import com.aproperfox.itunessearch.api.models.Attribute
import com.aproperfox.itunessearch.api.models.Entity
import com.aproperfox.itunessearch.api.models.MediaType
import java.util.*

interface BetteriTunesSearchApi {

  companion object {
    private val DEFAULT_LOCALE = Locale.US
    private const val DEFAULT_VERSION = 2
  }

  fun search(
      term: String,
      locale: Locale = DEFAULT_LOCALE,
      media: MediaType? = null,
      entity: Entity? = null,
      attribute: Attribute? = null,
      @IntRange(from = 0, to = 250) limit: Int? = null,
      version: Int? = DEFAULT_VERSION,
      explicit: Boolean? = false
  )

  fun lookupByArtistId(amgArtistId: Int)
  fun lookupByAlbumId(amgAlbumId: Int)
  fun lookupByVideoId(amgVideoId: Int)
  fun lookupByiTunesId(iTunesId: Int)
  fun lookupByUPC(upc: Int)
  fun lookupByISBN(isbn: Int)

}