package com.aproperfox.itunessearch

import com.aproperfox.itunessearch.api.BetteriTunesSearchApi
import com.aproperfox.itunessearch.api.iTunesSearchApi
import com.aproperfox.itunessearch.api.models.*
import com.aproperfox.itunessearch.viewmodels.SelectCategoryActivityViewModel
import com.aproperfox.itunessearch.viewmodels.SelectCategoryViewModel
import com.aproperfox.itunessearch.viewmodels.viewstate.SelectCategoryViewState
import com.aproperfox.itunessearch.views.models.DisplayData
import com.aproperfox.itunessearch.views.models.PayloadData
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.BDDMockito.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ViewModelTests {

  @Rule
  @JvmField
  val testRule = ImmediateSchedulersRule()

  @Mock
  lateinit var api: BetteriTunesSearchApi

  lateinit var viewModel: SelectCategoryViewModel

  @Before
  fun setup() {
    viewModel = SelectCategoryActivityViewModel(api)
  }

  val result = SearchResult(
      wrapperType = WrapperType.ArtistFor,
      kind = Kind.ArtistFor,
      artistId = 1,
      trackId = 1,
      collectionId = 1,
      artistName = "John Travolta",
      trackName = "Greased Lightning",
      collectionName = "Greatest hits",
      artistViewUrl = "https://tacos.com"
  )

  @Test
  fun requestShouldCallApiMethod() {
    val term = "John"

    viewModel.search(term)
    val response = SearchResponse(1, listOf(result))
    Mockito.verify(api, Mockito.times(1)).search(term)
  }

  @Test
  fun emptyRequestShouldYieldEmptyResult() {
    viewModel.search("")

    val o = TestObserver.create<SelectCategoryViewState>()
    viewModel.stateChanges.subscribe(o)
    o.assertValue(SelectCategoryViewState.Empty)
  }

}