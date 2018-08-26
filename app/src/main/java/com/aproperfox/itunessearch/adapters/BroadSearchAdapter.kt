package com.aproperfox.itunessearch.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.aproperfox.itunessearch.adapters.BroadSearchAdapter.ViewType.*
import com.aproperfox.itunessearch.views.AlbumViewHolder
import com.aproperfox.itunessearch.views.ArtistViewHolder
import com.aproperfox.itunessearch.views.HeaderViewHolder
import com.aproperfox.itunessearch.views.models.ViewHolderMediaData

class BroadSearchAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  enum class ViewType {
    Header,
    Album,
    Artist,
    Song,
    SeeMore
  }

  lateinit var items: List<ViewHolderMediaData>

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
      when (values()[viewType]) {
        Header -> HeaderViewHolder(parent)
        Album -> AlbumViewHolder(parent)
        Artist -> ArtistViewHolder(parent, View.OnClickListener{ })
        Song -> TODO()
        SeeMore -> TODO()
      }

  override fun getItemCount(): Int = items.size

  override fun getItemViewType(position: Int): Int =
      when (items[position]) {
        is ViewHolderMediaData.Album -> Album.ordinal
        is ViewHolderMediaData.Artist -> Artist.ordinal
        is ViewHolderMediaData.Header -> Header.ordinal
        is ViewHolderMediaData.Song -> Song.ordinal
        is ViewHolderMediaData.SeeMore -> SeeMore.ordinal
      }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val item = items[position]
    when (holder) {
      is HeaderViewHolder -> holder.bind(item as ViewHolderMediaData.Header)
      is AlbumViewHolder -> holder.bind(item as ViewHolderMediaData.Album)
      is ArtistViewHolder -> holder.bind(item as ViewHolderMediaData.Artist)
    }
  }
}