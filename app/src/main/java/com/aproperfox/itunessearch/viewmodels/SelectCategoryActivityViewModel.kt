package com.aproperfox.itunessearch.viewmodels

import com.aproperfox.itunessearch.api.BetteriTunesSearchApi
import com.aproperfox.itunessearch.api.BetteriTunesSearchManager
import com.aproperfox.itunessearch.api.models.Kind
import com.aproperfox.itunessearch.api.models.MediaType
import com.aproperfox.itunessearch.viewmodels.viewstate.SelectCategoryViewState
import com.aproperfox.itunessearch.views.models.DisplayData
import com.aproperfox.itunessearch.views.models.PayloadData
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData
import io.reactivex.Observable
import io.reactivex.disposables.Disposables
import io.reactivex.subjects.BehaviorSubject

class SelectCategoryActivityViewModel(
    private val iTunesSearchManager: BetteriTunesSearchApi
) : SelectCategoryViewModel {
  private val state: BehaviorSubject<SelectCategoryViewState> = BehaviorSubject.create()

  private var disposable = Disposables.disposed()

  override val stateChanges: Observable<SelectCategoryViewState> = state

  override fun search(keyword: String) {
    if (disposable.isDisposed) {
      iTunesSearchManager.search(keyword)
          .map { results ->
            results.filter {
              it.kind in listOf(Kind.Album, Kind.Song, Kind.ArtistFor)
            }.map { result ->
              when (result.kind) {
                Kind.Book -> TODO()
                Kind.Album -> ViewHolderMediaData(
                    DisplayData.Album(
                        imageUrl = result.artworkUrl100,
                        title = result.collectionName,
                        artist = result.artistName
                    ),
                    PayloadData(
                        result.collectionId,
                        MediaType.Music,
                        result.collectionViewUrl!!
                    )
                )
                Kind.CoachedAudio -> TODO()
                Kind.FeatureMovie -> TODO()
                Kind.InteractiveBooklet -> TODO()
                Kind.MusicVideo -> TODO()
                Kind.PdfPodcast -> TODO()
                Kind.PodcastEpisode -> TODO()
                Kind.SoftwarePackage -> TODO()
                Kind.Song -> ViewHolderMediaData(
                    DisplayData.Song(
                        title = result.trackName,
                        artist = result.artistName,
                        album = result.collectionName
                    ),
                    PayloadData(
                        result.trackId,
                        MediaType.Music,
                        result.trackViewUrl!!
                    )
                )
                Kind.TvEpisode -> TODO()
                Kind.ArtistFor -> ViewHolderMediaData(
                    DisplayData.Artist(
                        imageUrl = result.artworkUrl100,
                        name = result.artistName
                    ),
                    PayloadData(
                        result.collectionId,
                        MediaType.Music,
                        result.artistViewUrl!!
                    )
                )
              }
            }
          }
    }
  }

  override fun isDisposed(): Boolean = disposable.isDisposed

  override fun dispose() {
    disposable.dispose()
  }
}