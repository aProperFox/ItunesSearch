package com.aproperfox.itunessearch.api

import com.aproperfox.itunessearch.api.models.Attribute
import com.aproperfox.itunessearch.api.models.Entity
import com.aproperfox.itunessearch.api.models.MediaType
import java.util.*

class BetteriTunesSearchManager(private val iTunesSearchApi: iTunesSearchApi) : BetteriTunesSearchApi {
  override fun search(
      term: String,
      locale: Locale,
      media: MediaType?,
      entity: Entity?,
      attribute: Attribute?,
      limit: Int?,
      version: Int?,
      explicit: Boolean?
  ) = iTunesSearchApi.search(
      term = term,
      country = locale.country,
      media = media?.key,
      entity = entity?.entity,
      attribute = attribute?.attribute,
      limit = limit,
      version = version,
      explicit = explicit?.let { if (it) "Yes" else "No" }
  )

  override fun lookupByArtistId(amgArtistId: Int) =
      iTunesSearchApi.lookupByArtistId(amgArtistId)

  override fun lookupByAlbumId(amgAlbumId: Int) =
      iTunesSearchApi.lookupByAlbumId(amgAlbumId)

  override fun lookupByVideoId(amgVideoId: Int) =
      iTunesSearchApi.lookupByVideoId(amgVideoId)

  override fun lookupByiTunesId(iTunesId: Int) =
      iTunesSearchApi.lookupById(iTunesId)

  override fun lookupByUPC(upc: Int) =
      iTunesSearchApi.lookupByUPC(upc)

  override fun lookupByISBN(isbn: Int) =
      iTunesSearchApi.lookupByISBN(isbn)
}