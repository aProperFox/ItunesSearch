package com.aproperfox.itunessearch.api.models

data class SearchResult(
    val wrapperType: WrapperType,
    val kind: Kind,
    val trackExplicitness: Explicitness? = null,
    val collectionExplicitness: Explicitness? = null,
    val trackName: String,
    val artistName: String,
    val collectionName: String,
    val trackCensoredName: String? = null,
    val collectionCensoredName: String? = null,
    val artworkUrl100: String? = null,
    val artworkUrl60: String? = null,
    val artistViewUrl: String? = null,
    val collectionViewUrl: String? = null,
    val trackViewUrl: String? = null,
    val artistId: Int,
    val collectionId: Int,
    val trackId: Int,
    val previewUrl: String? = null,
    val trackTimeMillis: Long? = null
)