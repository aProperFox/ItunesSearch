package com.aproperfox.itunessearch.api.models

data class SearchResponse(
    val resultCount: Int,
    val results: List<SearchResult>
)