package com.aproperfox.itunessearch.api.models

import com.google.gson.annotations.SerializedName

enum class Explicitness {
  @SerializedName("explicit")
  Explicit,
  @SerializedName("cleaned")
  Cleaned,
  @SerializedName("notExplicit")
  NotExplicit
}