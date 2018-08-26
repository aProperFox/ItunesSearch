package com.aproperfox.itunessearch.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.aproperfox.itunessearch.adapters.BroadSearchAdapter.ViewType.*
import com.aproperfox.itunessearch.views.*
import com.aproperfox.itunessearch.views.models.DisplayData
import com.aproperfox.itunessearch.views.models.PayloadData
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData

class BroadSearchAdapter(private val clickListener: (PayloadData) -> Unit) : RecyclerView.Adapter<BaseViewHolder>() {

  companion object {
    private const val CATEGORY_RESULT_COUNT = 5
    private const val SONG_HEADER = "Songs"
    private const val ARTIST_HEADER = "Artists"
    private const val ALBUM_HEADER = "Albums"
  }

  enum class ViewType {
    Header,
    Album,
    Artist,
    Song,
    SeeMore
  }

  var items: List<ViewHolderMediaData> = emptyList()
    set(value) {
      field = separateItems(value)
    }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
      when (values()[viewType]) {
        Header -> HeaderViewHolder(parent)
        Album -> AlbumViewHolder(parent, clickListener)
        Artist -> ArtistViewHolder(parent, clickListener)
        Song -> SongViewHolder(parent, clickListener)
        SeeMore -> SeeMoreViewHolder(parent, clickListener)
      }

  override fun getItemCount(): Int = items.size

  override fun getItemViewType(position: Int): Int =
      when (items[position].displayData) {
        is DisplayData.Album -> Album.ordinal
        is DisplayData.Artist -> Artist.ordinal
        is DisplayData.Header -> Header.ordinal
        is DisplayData.Song -> Song.ordinal
        is DisplayData.SeeMore -> SeeMore.ordinal
      }

  override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
    holder.bind(items[position])
  }

  private fun separateItems(items: List<ViewHolderMediaData>): List<ViewHolderMediaData> {
    val artists = items.filter { it.displayData is DisplayData.Artist }.take(CATEGORY_RESULT_COUNT)
    val songs = items.filter { it.displayData is DisplayData.Song }.take(CATEGORY_RESULT_COUNT)
    val albums = items.filter { it.displayData is DisplayData.Album }.take(CATEGORY_RESULT_COUNT)
    val newList: MutableList<ViewHolderMediaData> = mutableListOf()
    if (artists.isNotEmpty()) {
      newList.add(ViewHolderMediaData(DisplayData.Header(ARTIST_HEADER), null))
      artists.forEach { artist ->
        newList.add(artist)
      }
    }
    if (songs.isNotEmpty()) {
      newList.add(ViewHolderMediaData(DisplayData.Header(SONG_HEADER), null))
      songs.forEach { song ->
        newList.add(song)
      }
    }
    if (albums.isNotEmpty()) {
      newList.add(ViewHolderMediaData(DisplayData.Header(ALBUM_HEADER), null))
      albums.forEach { album ->
        newList.add(album)
      }
    }
    return newList
  }
}