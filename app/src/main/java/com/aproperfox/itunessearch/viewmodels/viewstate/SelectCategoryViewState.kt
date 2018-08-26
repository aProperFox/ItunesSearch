package com.aproperfox.itunessearch.viewmodels.viewstate

import com.aproperfox.itunessearch.views.models.ViewHolderMediaData

sealed class SelectCategoryViewState {
  data class Content(val items: List<ViewHolderMediaData>) : SelectCategoryViewState()
  object Loading : SelectCategoryViewState()
  object Empty : SelectCategoryViewState()
  data class Error(val error: String) : SelectCategoryViewState()
}