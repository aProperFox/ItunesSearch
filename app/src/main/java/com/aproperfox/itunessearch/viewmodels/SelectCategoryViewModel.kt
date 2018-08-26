package com.aproperfox.itunessearch.viewmodels

import com.aproperfox.itunessearch.api.models.SearchResults
import com.aproperfox.itunessearch.viewmodels.viewstate.SelectCategoryViewState
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

interface SelectCategoryViewModel : Disposable {
  val stateChanges: Observable<SelectCategoryViewState>
  fun search(keyword: String)
}