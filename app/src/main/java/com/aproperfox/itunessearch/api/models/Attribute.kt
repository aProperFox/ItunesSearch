package com.aproperfox.itunessearch.api.models

sealed class Attribute(open val attribute: String) {
  sealed class Movie(override val attribute: String) : Attribute(attribute) {
    object ActorTerm : Movie("actorTerm")
    object ShortFilmTerm : Movie("shortFilmTerm")
    object ProducerTerm : Movie("producerTerm")
    object RatingTerm : Movie("ratingTerm")
    object DirectorTerm : Movie("directorTerm")
    object ReleaseYearTerm : Movie("releaseYearTerm")
    object FeatureFilmTerm : Movie("featureFilmTerm")
    object MovieArtistTerm : Movie("movieArtistTerm")
    object MovieTerm : Movie("movieTerm")
    object RatingIndex : Movie("ratingIndex")
    object DescriptionTerm : Movie("descriptionTerm")
  }

  sealed class Podcast(override val attribute: String) : Attribute(attribute) {
    object TitleTerm : Podcast("titleTerm")
    object LanguageTerm : Podcast("languageTerm")
    object AuthorTerm : Podcast("authorTerm")
    object GenreIndex : Podcast("genreIndex")
    object ArtistTerm : Podcast("artistTerm")
    object RatingIndex : Podcast("ratingIndex")
    object KeywordsTerm : Podcast("keywordsTerm")
    object DescriptionTerm : Podcast("descriptionTerm")
  }

  sealed class Music(override val attribute: String) : Attribute(attribute) {
    object MixTerm : Music("mixTerm")
    object GenreIndex : Music("genreIndex")
    object ArtistTerm : Music("artistTerm")
    object ComposerTerm : Music("composerTerm")
    object AlbumTerm : Music("albumTerm")
    object RatingIndex : Music("ratingIndex")
    object SongTerm : Music("songTerm")
  }

  sealed class MusicVideo(override val attribute: String) : Attribute(attribute) {
    object GenreIndex : MusicVideo("genreIndex")
    object ArtistTerm : MusicVideo("artistTerm")
    object AlbumTerm : MusicVideo("albumTerm")
    object RatingIndex : MusicVideo("ratingIndex")
    object SongTerm : MusicVideo("songTerm")
  }

  sealed class AudioBook(override val attribute: String) : Attribute(attribute) {
    object TitleTerm : AudioBook("titleTerm")
    object AuthorTerm : AudioBook("authorTerm")
    object GenreIndex : AudioBook("genreIndex")
    object RatingIndex : AudioBook("ratingIndex")
  }

  sealed class ShortFilm(override val attribute: String) : Attribute(attribute) {
    object GenreIndex : ShortFilm("genreIndex")
    object ArtistTerm : ShortFilm("artistTerm")
    object ShortFilmTerm : ShortFilm("shortFilmTerm")
    object RatingIndex : ShortFilm("ratingIndex")
    object DescriptionTerm : ShortFilm("descriptionTerm")
  }

  sealed class Software(override val attribute: String) : Attribute(attribute) {
    object SoftwareDeveloper : Software("softwareDeveloper")
  }

  sealed class TvShow(override val attribute: String) : Attribute(attribute) {
    object GenreIndex : TvShow("genreIndex")
    object TvEpisodeTerm : TvShow("tvEpisodeTerm")
    object ShowTerm : TvShow("showTerm")
    object TvSeasonTerm : TvShow("tvSeasonTerm")
    object RatingIndex : TvShow("ratingIndex")
    object DescriptionTerm : TvShow("descriptionTerm")
  }

  sealed class All(override val attribute: String) : Attribute(attribute) {
    object ActorTerm : All("actorTerm")
    object LanguageTerm : All("languageTerm")
    object AllArtistTerm : All("allArtistTerm")
    object TvEpisodeTerm : All("tvEpisodeTerm")
    object ShortFilmTerm : All("shortFilmTerm")
    object DirectorTerm : All("directorTerm")
    object ReleaseYearTerm : All("releaseYearTerm")
    object TitleTerm : All("titleTerm")
    object FeatureFilmTerm : All("featureFilmTerm")
    object RatingIndex : All("ratingIndex")
    object KeywordsTerm : All("keywordsTerm")
    object DescriptionTerm : All("descriptionTerm")
    object AuthorTerm : All("authorTerm")
    object GenreIndex : All("genreIndex")
    object MixTerm : All("mixTerm")
    object AllTrackTerm : All("allTrackTerm")
    object ArtistTerm : All("artistTerm")
    object ComposerTerm : All("composerTerm")
    object TvSeasonTerm : All("tvSeasonTerm")
    object ProducerTerm : All("producerTerm")
    object RatingTerm : All("ratingTerm")
    object SongTerm : All("songTerm")
    object MovieArtistTerm : All("movieArtistTerm")
    object ShowTerm : All("showTerm")
    object MovieTerm : All("movieTerm")
    object AlbumTerm : All("albumTerm")
  }
}