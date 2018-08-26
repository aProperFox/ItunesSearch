package com.aproperfox.itunessearch.views.models

import com.aproperfox.itunessearch.api.models.MediaType

data class PayloadData(
    val id: Int,
    val category: MediaType
)