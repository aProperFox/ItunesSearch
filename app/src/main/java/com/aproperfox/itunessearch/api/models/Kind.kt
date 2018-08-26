package com.aproperfox.itunessearch.api.models

import com.google.gson.annotations.SerializedName

enum class Kind {
  @SerializedName("book")
  Book,
  @SerializedName("album")
  Album,
  @SerializedName("coached-audio")
  CoachedAudio,
  @SerializedName("feature-movie")
  FeatureMovie,
  @SerializedName("interactive-booklet")
  InteractiveBooklet,
  @SerializedName("music-video")
  MusicVideo,
  @SerializedName("pdf podcast")
  PdfPodcast,
  @SerializedName("podcast-episode")
  PodcastEpisode,
  @SerializedName("software-package")
  SoftwarePackage,
  @SerializedName("song")
  Song,
  @SerializedName("tv-episode")
  TvEpisode,
  @SerializedName("artistFor")
  ArtistFor
}