package com.aproperfox.itunessearch.api.models

import com.google.gson.annotations.SerializedName

enum class WrapperType {
  @SerializedName("track")
  Track,
  @SerializedName("collection")
  Collection,
  @SerializedName("artistFor")
  ArtistFor
}