package com.aproperfox.itunessearch.views.models

sealed class ViewHolderMediaData {

  data class Header(
      val title: String
  ) : ViewHolderMediaData()

  data class Album(
      val imageUrl: String?,
      val title: String,
      val artist: String
  ) : ViewHolderMediaData()

  data class Artist(
      val imageUrl: String?,
      val name: String
  ) : ViewHolderMediaData()

  data class Song(
      val title: String,
      val artist: String,
      val album: String?
  ) : ViewHolderMediaData()

  data class SeeMore(
      val category: String
  ) : ViewHolderMediaData()

}