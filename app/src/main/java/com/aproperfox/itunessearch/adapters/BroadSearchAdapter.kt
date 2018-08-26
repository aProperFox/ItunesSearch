package com.aproperfox.itunessearch.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.aproperfox.itunessearch.adapters.BroadSearchAdapter.ViewType.*
import com.aproperfox.itunessearch.views.*
import com.aproperfox.itunessearch.views.models.DisplayData
import com.aproperfox.itunessearch.views.models.PayloadData
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData

class BroadSearchAdapter(private val clickListener: (PayloadData) -> Unit) : RecyclerView.Adapter<BaseViewHolder>() {

  enum class ViewType {
    Header,
    Album,
    Artist,
    Song,
    SeeMore
  }

  var items: List<ViewHolderMediaData> = emptyList()

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
}