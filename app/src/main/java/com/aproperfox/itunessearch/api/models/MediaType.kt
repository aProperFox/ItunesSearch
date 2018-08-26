package com.aproperfox.itunessearch.api.models

enum class MediaType(val key: String) {
  Movie("movie"),
  Podcast("podcast"),
  Music("music"),
  MusicVideo("musicVideo"),
  Audiobook("audiobook"),
  ShortFilm("shortFilm"),
  TvShow("tvShow"),
  Software("software"),
  Ebook("ebook"),
  All("all");

  companion object {
    fun fromKey(key: String): MediaType =
        values()
            .find { it.key == key }
            ?: throw IllegalArgumentException("MediaType $key is not valid.\nAcceptable values: ${values().joinToString(", ")}")
  }
}