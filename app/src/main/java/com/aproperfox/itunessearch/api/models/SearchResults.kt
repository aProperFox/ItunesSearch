package com.aproperfox.itunessearch.api.models

data class SearchResults(
    val wrapperType: WrapperType,
    val kind: Kind,
    val trackExplicitness: Explicitness?,
    val collectionExplicitness: Explicitness?,
    val trackName: String,
    val artistName: String,
    val collectionName: String,
    val trackCensoredName: String?,
    val collectionCensoredName: String?,
    val artworkUrl100: String?,
    val artworkUrl60: String?,
    val artistViewUrl: String?,
    val collectionViewUrl: String?,
    val trackViewUrl: String?,
    val artistId: Int,
    val collectionId: Int,
    val trackId: Int,
    val previewUrl: String?,
    val trackTimeMillis: Long?
)