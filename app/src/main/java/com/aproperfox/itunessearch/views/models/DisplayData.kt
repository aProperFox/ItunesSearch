package com.aproperfox.itunessearch.views.models

sealed class DisplayData {
  data class Header(
      val title: String
  ) : DisplayData()

  data class Album(
      val imageUrl: String?,
      val title: String,
      val artist: String
  ) : DisplayData()

  data class Artist(
      val imageUrl: String?,
      val name: String
  ) : DisplayData()

  data class Song(
      val title: String,
      val artist: String,
      val album: String?
  ) : DisplayData()

  data class SeeMore(
      val category: String
  ) : DisplayData()
}