package com.aproperfox.itunessearch.api.models


sealed class Entity(open val entity: String) {
  sealed class Movie(override val entity: String) : Entity(entity) {
    object MovieArtist : Movie("movieArtist")
    object MovieEntity : Movie("movie")
  }

  sealed class Podcast(override val entity: String) : Entity(entity) {
    object PodcastAuthor : Podcast("podcastAuthor")
    object PodcastEntity : Podcast("podcast")
  }

  sealed class Music(override val entity: String) : Entity(entity) {
    object MusicArtist : Music("musicArtist")
    object MusicTrack : Music("musicTrack")
    object Album : Music("album")
    object MusicVideo : Music("musicVideo")
    object Mix : Music("mix")
    object Song : Music("song")
  }

  sealed class MusicVideo(override val entity: String) : Entity(entity) {
    object MusicArtist : MusicVideo("musicArtist")
    object MusicVideoEntity : MusicVideo("musicVideo")
  }

  sealed class AudioBook(override val entity: String) : Entity(entity) {
    object AudiobookAuthor : AudioBook("audiobookAuthor")
    object AudiobookEntity : AudioBook("audiobook")
  }

  sealed class ShortFilm(override val entity: String) : Entity(entity) {
    object ShortFilmArtist : ShortFilm("shortFilmArtist")
    object ShortFilmEntity : ShortFilm("shortFilm")
  }

  sealed class TvShow(override val entity: String) : Entity(entity) {
    object TvEpisode : TvShow("tvEpisode")
    object TvSeason : TvShow("tvSeason")
  }

  sealed class Software(override val entity: String) : Entity(entity) {
    object SoftwareEntity : Software("software")
    object iPadSoftware : Software("iPadSoftware")
    object MacSoftware : Software("macSoftware")
  }

  sealed class Ebook(override val entity: String) : Entity(entity) {
    object EbookEntity : Ebook("ebook")
  }

  sealed class All(override val entity: String) : Entity(entity) {
    object Movie : All("movie")
    object Album : All("album")
    object AllArtist : All("allArtist")
    object Podcast : All("podcast")
    object MusicVideo : All("musicVideo")
    object Mix : All("mix")
    object Audiobook : All("audiobook")
    object TvSeason : All("tvSeason")
    object AllTrack : All("allTrack")
  }
}
